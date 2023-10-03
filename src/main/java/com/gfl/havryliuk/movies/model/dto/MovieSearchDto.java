package com.gfl.havryliuk.movies.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovieSearchDto {

    private String genre;
    private String title;
    private String director;
    private String actor;
    private String originCountry;

    public MovieSearchDto() {
    }


}
