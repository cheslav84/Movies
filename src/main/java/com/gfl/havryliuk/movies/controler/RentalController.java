package com.gfl.havryliuk.movies.controler;

import com.gfl.havryliuk.movies.model.dto.RentalDto;
import com.gfl.havryliuk.movies.model.entity.Customer;
import com.gfl.havryliuk.movies.model.entity.Movie;
import com.gfl.havryliuk.movies.model.entity.Rental;
import com.gfl.havryliuk.movies.model.service.CustomerService;
import com.gfl.havryliuk.movies.model.service.MovieService;
import com.gfl.havryliuk.movies.model.service.MovieTypeService;
import com.gfl.havryliuk.movies.model.service.RentalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/customers/{id}/rentals")
public class RentalController {

    private final RentalService service;
    private final MovieService movieService;
    private final CustomerService customerService;


    @Autowired
    public RentalController(RentalService service, MovieService movieService, CustomerService customerService) {
        this.service = service;
        this.movieService = movieService;
        this.customerService = customerService;
    }



    @GetMapping("/add")
    public ModelAndView addRentalPage(@PathVariable String id, ModelAndView modelAndView) {
        log.trace("get:/customers/{}/rentals/add", id);
        Iterable<Movie> movies = movieService.getAllMovies();
        Customer customer = customerService.getCustomer(id);
        modelAndView.addObject("rental", new RentalDto());
        modelAndView.addObject("movies", movies);
        modelAndView.addObject("customer", customer);

        modelAndView.setViewName("new-rental");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRental(@PathVariable String id, RentalDto rentalDto, ModelAndView modelAndView) {
        log.trace("post:/customers/{}/rentals/add", id);
        rentalDto.setCustomerId(id);
        service.saveRental(rentalDto);
        modelAndView.setViewName("redirect:/customers/" + id);
        return modelAndView;
    }

    @PostMapping("/close")
    public ModelAndView closeRentals(@PathVariable String id, Customer customer, ModelAndView modelAndView) {
        log.trace("post:/customers/{}/rentals/add", id);

//        rentalDto.setCustomerId(id);
//        service.saveRental(rentalDto);
        modelAndView.setViewName("redirect:/customers/" + id);
        return modelAndView;
    }

}