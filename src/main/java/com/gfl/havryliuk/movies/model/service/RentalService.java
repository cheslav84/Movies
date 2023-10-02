package com.gfl.havryliuk.movies.model.service;

import com.gfl.havryliuk.movies.model.dto.RentalDto;
import com.gfl.havryliuk.movies.model.entity.Rental;
import com.gfl.havryliuk.movies.model.repository.CustomerRepository;
import com.gfl.havryliuk.movies.model.repository.MovieRepository;
import com.gfl.havryliuk.movies.model.repository.RentalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
public class RentalService {
    private final RentalRepository repository;
    private final CustomerRepository customerRepository;
    private final MovieRepository movieRepository;


    @Autowired
    public RentalService(RentalRepository repository, CustomerRepository customerRepository, MovieRepository movieRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
        this.movieRepository = movieRepository;
    }

    public void saveRental(RentalDto rentalDto) {
        Rental rental = Rental.builder()
                .customer(customerRepository.findById(rentalDto.getCustomerId()).orElseThrow())
                .movie(movieRepository.findById(rentalDto.getMovieId()).orElseThrow())
                .rentedDate(LocalDateTime.now())
                .open(true)
                .build();
        repository.save(rental);
    }
}
