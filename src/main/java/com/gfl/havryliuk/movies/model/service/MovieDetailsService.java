package com.gfl.havryliuk.movies.model.service;

import com.gfl.havryliuk.movies.model.dto.MovieDetailsDto;
import com.gfl.havryliuk.movies.model.entity.Movie;
import com.gfl.havryliuk.movies.model.entity.details.*;
import com.gfl.havryliuk.movies.model.repository.ActorRepository;
import com.gfl.havryliuk.movies.model.repository.MovieDetailsRepository;
import com.gfl.havryliuk.movies.model.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@Service
public class MovieDetailsService {
    private final MovieRepository movieRepository;
    private final MovieDetailsRepository repository;
    private final ActorRepository actorRepository;


    @Autowired
    public MovieDetailsService(MovieRepository movieRepository, MovieDetailsRepository repository,
                               ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.repository = repository;
        this.actorRepository = actorRepository;
    }


    @Transactional
    public Movie addMovieDetails(MovieDetailsDto detailsDto) {
        Movie movie = movieRepository.findById(detailsDto.getMovie().getId()).orElseThrow();

        setDescription(detailsDto, movie);
        setDirector(detailsDto, movie);
        setOriginCountry(detailsDto, movie);
        setActors(detailsDto, movie);

        movieRepository.save(movie);
        return movie;

    }

    private void setDescription(MovieDetailsDto detailsDto, Movie movie) {
        if (detailsDto.getDescription() != null && !detailsDto.getDescription().isEmpty()) {
            movie.getMovieDetails().add(new Description(movie, detailsDto.getDescription()));
        }
    }

    private void setDirector(MovieDetailsDto detailsDto, Movie movie) {
        if (detailsDto.getDirector() != null && !detailsDto.getDirector().isEmpty()) {
            MovieDetails director = repository.findByDirector(detailsDto.getDirector())
                    .orElseGet(() -> new Director(movie, detailsDto.getDirector()));
            movie.getMovieDetails().add(director);
        }
    }

    private void setOriginCountry(MovieDetailsDto detailsDto, Movie movie) {
        if (detailsDto.getOriginCountry() != null && !detailsDto.getOriginCountry().isEmpty()) {
            MovieDetails originCountry = repository.findByOriginCountry(detailsDto.getOriginCountry())
                    .orElseGet(() -> new OriginCountry(movie, detailsDto.getOriginCountry()));
            movie.getMovieDetails().add(originCountry);
        }
    }

    private void setActors(MovieDetailsDto detailsDto, Movie movie) {
        if (detailsDto.getActors() != null && detailsDto.getActors().length() != 0) {
            Set<Actor> actorSet = getActors(detailsDto);
            Actors actors = new Actors(movie, actorSet);
            assignActorsForMovies(actorSet, actors);
            movie.getMovieDetails().add(actors);
        }
    }

    private Set<Actor> getActors(MovieDetailsDto detailsDto) {
        String[] actorsArr = detailsDto.getActors().split(",");
        return Arrays.stream(actorsArr)
                .map(String::strip)
                .map(a -> actorRepository.findByName(a)
                        .orElseGet(() -> new Actor(a)))
                .collect(Collectors.toSet());
    }

    private void assignActorsForMovies(Set<Actor> actorSet, Actors actors) {
        for (Actor actor : actorSet) {
            actor.getMovieDetails().add(actors);
        }
    }


}
