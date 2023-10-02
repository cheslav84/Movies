package com.gfl.havryliuk.movies.controler;

import com.gfl.havryliuk.movies.model.dto.MovieDetailsDto;
import com.gfl.havryliuk.movies.model.entity.Movie;
import com.gfl.havryliuk.movies.model.repository.MovieDetailsRepository;
import com.gfl.havryliuk.movies.model.service.MovieDetailsService;
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
@RequestMapping("/movies/details")
public class MovieDetailsController {

    private final MovieService movieService;
    private final MovieDetailsService service;

    @Autowired
    public MovieDetailsController(MovieService movieService, MovieDetailsService service) {
        this.movieService = movieService;
        this.service = service;
    }



    @GetMapping("/add/{id}")
    public ModelAndView addMovieDetailsPage(@PathVariable String id, ModelAndView modelAndView) {
        log.trace("get:/movies/details/add/{}", id);
        Movie movie = movieService.getMovie(id);
        modelAndView.addObject("detailsDto", new MovieDetailsDto(movie));
        modelAndView.setViewName("add-details");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addMovieDetails(MovieDetailsDto detailsDto, ModelAndView modelAndView) {
        log.trace("post:/movies/details/add");

        Movie movie = service.addMovieDetails(detailsDto);
        modelAndView.addObject("movie", movie);
        modelAndView.setViewName("redirect:/movies/" + movie.getId());

        return modelAndView;
    }
}