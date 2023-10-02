package com.gfl.havryliuk.movies.model.entity.details;

import com.gfl.havryliuk.movies.model.entity.Movie;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MovieDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

//    @Column(nullable = false)
    protected String details;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "movie_id")
    @ManyToMany(mappedBy = "movieDetails")
    protected Set<Movie> movies = new HashSet<>();


    public MovieDetails(Movie movie, String details) {
        movies.add(movie);
//        movie.getMovieDetails().add(this);
        this.details = details;
    }

    @Override
    public String toString() {
//        return details.substring(0, 1).toUpperCase() + details.substring(1) + ": ";
        return details + ": ";

    }
}
