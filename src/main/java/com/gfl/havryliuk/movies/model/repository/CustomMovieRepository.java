package com.gfl.havryliuk.movies.model.repository;

import com.gfl.havryliuk.movies.model.dto.MovieSearchDto;
import com.gfl.havryliuk.movies.model.entity.Movie;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CustomMovieRepository extends Repository<Movie, String> {
    List<Movie> findByOptions(MovieSearchDto movieSearchDto);
}
