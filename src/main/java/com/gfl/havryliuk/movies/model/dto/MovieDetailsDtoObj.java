//package com.gfl.havryliuk.movies.model.dto;
//
//import com.gfl.havryliuk.movies.model.entity.Movie;
//import com.gfl.havryliuk.movies.model.entity.details.Actors;
//import com.gfl.havryliuk.movies.model.entity.details.Description;
//import com.gfl.havryliuk.movies.model.entity.details.Director;
//import com.gfl.havryliuk.movies.model.entity.details.OriginCountry;
//import lombok.Getter;
//import lombok.Setter;
//
//
//@Getter
//@Setter
//public class MovieDetailsDtoObj {
//
//    private  Movie movie;
//    private Description description;
//    private Director director;
//    private OriginCountry originCountry;
//    private Actors actors;
//
//    public MovieDetailsDtoObj() {
//    }
//
//    public MovieDetailsDtoObj(Movie movie) {
//        this.movie = movie;
//        description = new Description(movie, "Description");
//        director = new Director(movie, "Director");
//        originCountry = new OriginCountry(movie, "Director");
//        actors = new Actors(movie, "Actors");
//    }
//
//
//    public Director getDirector() {
//        return director;
//    }
//}
