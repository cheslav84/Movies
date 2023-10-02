package com.gfl.havryliuk.movies.model.service;

import com.gfl.havryliuk.movies.model.entity.Movie;
import com.gfl.havryliuk.movies.model.repository.MovieDetailsRepository;
import com.gfl.havryliuk.movies.model.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Slf4j
@Service
public class MovieService {
    private final MovieRepository repository;
    private final MovieDetailsRepository movieDetailsRepository;


    @Autowired
    public MovieService(MovieRepository repository, MovieDetailsRepository movieDetailsRepository) {
        this.repository = repository;
        this.movieDetailsRepository = movieDetailsRepository;
    }

    public Iterable<Movie> getAllMovies(){
        return repository.findAll();
    }

    @Transactional
    public Movie getMovie(String id) {
        Movie movie = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        movie.getMovieDetails().addAll(movieDetailsRepository.findByMovies(movie));
        return movie;
    }

    public Movie saveMovie(Movie movie){
        return repository.save(movie);
    }

//    public Iterable<String> getMovieTitles() {
//        return repository.findAllMovieTitles();
//    }
}
