package com.gfl.havryliuk.movies.model.entity;


import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="MOVIE_TYPE")
public class MovieType {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String genre;

    @Embedded
    private RentalInfo rentalInfo;


    public MovieType(String genre) {
        this.genre = genre;
    }


//    private Set<Movie> movies; //equals and hashcode


}