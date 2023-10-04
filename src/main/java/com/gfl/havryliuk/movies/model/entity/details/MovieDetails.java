package com.gfl.havryliuk.movies.model.entity.details;

import com.gfl.havryliuk.movies.model.entity.Movie;
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
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MovieDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    protected String details;

    @ManyToMany(mappedBy = "movieDetails")
    protected Set<Movie> movies = new HashSet<>();


    public MovieDetails(Movie movie, String details) {
        movies.add(movie);
        this.details = details;
    }

    @Override
    public String toString() {
        return details + ": ";

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDetails that = (MovieDetails) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return details != null ? details.equals(that.details) : that.details == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }
}
