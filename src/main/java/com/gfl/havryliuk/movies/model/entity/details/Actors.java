package com.gfl.havryliuk.movies.model.entity.details;

import javax.persistence.*;

import com.gfl.havryliuk.movies.model.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@Entity
public class Actors extends MovieDetails{


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "ACTORS_ACTOR",
            joinColumns = @JoinColumn(name = "ACTORS_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID")
    )
    private Set<Actor> actors;

    public Actors(Movie movie, Set<Actor> actors) {
        super(movie, "Actors");
        this.actors = actors;
    }


    @Override
    public String toString() {
        return super.toString() + actors.stream()
                .map(Actor::toString)
                .collect(Collectors.joining(", "));
    }
}
