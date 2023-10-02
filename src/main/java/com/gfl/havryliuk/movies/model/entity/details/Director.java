package com.gfl.havryliuk.movies.model.entity.details;

import javax.persistence.*;

import com.gfl.havryliuk.movies.model.entity.Movie;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Director extends MovieDetails {

//    @Column(nullable = false)
    private String director;

    public Director(Movie movie, String director) {
        super(movie, "Director");
        this.director = director;
    }

//    @Override
//    String showDetails() {
//        return details + ": " + director;
//    }

    @Override
    public String toString() {
        return super.toString() + director;
    }
}
