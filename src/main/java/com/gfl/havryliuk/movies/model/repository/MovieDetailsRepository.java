package com.gfl.havryliuk.movies.model.repository;

import com.gfl.havryliuk.movies.model.entity.Movie;
import com.gfl.havryliuk.movies.model.entity.details.Actor;
import com.gfl.havryliuk.movies.model.entity.details.Director;
import com.gfl.havryliuk.movies.model.entity.details.MovieDetails;
import com.gfl.havryliuk.movies.model.entity.details.OriginCountry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MovieDetailsRepository extends CrudRepository<MovieDetails, String> {

    Set<MovieDetails> findByMovies(Movie movie);//todo
    Optional<Director> findByDirector(String director);
    Optional<OriginCountry> findByOriginCountry(String originCountry);

//    Optional<Actor> findByName(@Param("name")String name);


//    @Query("select ars from Actors ars join ars.actors a where a.name = :name")
//    Optional<Actor> findByName(@Param("name")String name);
}
