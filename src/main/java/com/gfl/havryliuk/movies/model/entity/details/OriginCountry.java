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

    private String originCountry;

    public OriginCountry(Movie movie, String originCountry) {
        super(movie, "Origin country");
        this.originCountry = originCountry;
    }

    @Override
    public String toString() {
        return super.toString() + originCountry;
    }
}
