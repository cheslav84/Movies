package com.gfl.havryliuk.movies.model.repository;

import com.gfl.havryliuk.movies.model.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
//    @Query("select distinct m.title from Movie m")
//    Iterable<String> findAllMovieTitles();
}
