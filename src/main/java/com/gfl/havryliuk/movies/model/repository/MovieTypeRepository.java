package com.gfl.havryliuk.movies.model.repository;

import com.gfl.havryliuk.movies.model.entity.MovieType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieTypeRepository extends CrudRepository<MovieType, String> {

    @Query("select distinct mt.genre from MovieType mt")
    Iterable<String> findAllGenres();
}
