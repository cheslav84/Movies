package com.gfl.havryliuk.movies.model.entity.details;

import javax.persistence.Entity;

import com.gfl.havryliuk.movies.model.entity.Movie;
import lombok.*;


@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Description extends MovieDetails {

    private String description;

    public Description(Movie movie, String description) {
        super(movie, "Description");
        this.description = description;
    }


    @Override
    public String toString() {
        return super.toString() + description;
    }
}
