package com.gfl.havryliuk.movies.model.dto;

import com.gfl.havryliuk.movies.model.entity.Movie;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovieDetailsDto {

    private Movie movie;
    private String movieId;
    private String movieTitle;
    private String description;
    private String director;
    private String originCountry;
    private String actors;

    public MovieDetailsDto() {
    }

    public MovieDetailsDto(Movie movie) {
        this.movieId = movie.getId();
        this.movieTitle = movie.getTitle();
    }




}
