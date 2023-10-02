package com.gfl.havryliuk.movies.model.service;

import com.gfl.havryliuk.movies.model.entity.Customer;
import com.gfl.havryliuk.movies.model.entity.Rental;
import com.gfl.havryliuk.movies.model.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class CustomerService {
    private final CustomerRepository repository;


    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Iterable<Customer> getAllCustomers(){
        return repository.findAll();
    }

    @Transactional
    public Customer getCustomer(String id) {
        Customer customer = repository.findById(id).orElseThrow(IllegalArgumentException::new);

        List<Rental> rentals = customer.getRentals();
        for (Rental rental: rentals) {
            LocalDateTime rentedDate = rental.getRentedDate();
            LocalDateTime today = LocalDateTime.now();
            Duration duration = Duration.between(today, rentedDate);
            int daysRented = (int) Math.abs(duration.toDays());
            rental.setDaysRented(daysRented);
        }
        return customer;
    }

    public Customer saveCustomer(Customer customer){
        return repository.save(customer);
    }

}
