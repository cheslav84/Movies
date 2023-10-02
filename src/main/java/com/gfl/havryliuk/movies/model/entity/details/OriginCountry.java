package com.gfl.havryliuk.movies.model.entity.details;

import com.gfl.havryliuk.movies.model.entity.Movie;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class OriginCountry extends MovieDetails {

//    @Column(nullable = false)
    private String originCountry;

    public OriginCountry(Movie movie, String originCountry) {
        super(movie, "Origin country");
        this.originCountry = originCountry;
    }

//    @Override
//    String showDetails() {
//        return details + ": " + director;
//    }

    @Override
    public String toString() {
        return super.toString() + originCountry;
    }
}
