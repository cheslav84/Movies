package com.gfl.havryliuk.movies.model.entity;

import com.gfl.havryliuk.movies.model.entity.details.MovieDetails;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String title;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)//todo check if work
    private MovieType movieType;

//    @OneToMany(mappedBy = "movie", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    @ManyToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "MOVIE_MOVIE_DETAILS",
            joinColumns = @JoinColumn(name = "MOVIE_ID"),
            inverseJoinColumns = @JoinColumn(name = "DETAILS_ID")
    )
    //    private List<MovieDetails> movieDetails = new ArrayList<>();
    private Set<MovieDetails> movieDetails = new HashSet<>();

    public void addDetails(MovieDetails movieDetail) {
        this.movieDetails.add(movieDetail);
    }
}
