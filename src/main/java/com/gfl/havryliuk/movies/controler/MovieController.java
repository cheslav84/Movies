package com.gfl.havryliuk.movies.controler;

import com.gfl.havryliuk.movies.model.entity.Movie;

import com.gfl.havryliuk.movies.model.service.MovieService;
import com.gfl.havryliuk.movies.model.service.MovieTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;
    private final MovieTypeService movieTypeService;

    @Autowired
    public MovieController(MovieService service, MovieTypeService movieTypeService) {
        this.service = service;
        this.movieTypeService = movieTypeService;
    }


    @GetMapping("/all")
    public ModelAndView getAllMovies(ModelAndView modelAndView) {
        log.trace("get:/movies/all");
        modelAndView.addObject("movies", service.getAllMovies());
        modelAndView.setViewName("movies");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getMovie(@PathVariable String id, ModelAndView modelAndView) {
        log.trace("get:/movie/{}", id);
        modelAndView.addObject("movie", service.getMovie(id));
        modelAndView.setViewName("movie-info");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addMoviePage(ModelAndView modelAndView) {
        log.trace("get:/movies/add");
        modelAndView.addObject("movie", new Movie());
        modelAndView.addObject("genres", movieTypeService.getAllGenres());
        modelAndView.setViewName("new-movie");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addMovie(Movie movie, ModelAndView modelAndView) {
        log.trace("post:/movies/add");
        service.saveMovie(movie);
        modelAndView.setViewName("redirect:/movies/" + movie.getId());
        return modelAndView;
    }


}