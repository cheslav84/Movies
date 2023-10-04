package com.gfl.havryliuk.movies.model.service;

import com.gfl.havryliuk.movies.model.repository.MovieTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class MovieTypeService {
    private final MovieTypeRepository repository;


    @Autowired
    public MovieTypeService(MovieTypeRepository repository) {
        this.repository = repository;
    }

    public Iterable<String> getAllGenres(){
        return repository.findAllGenres();
    }

}
