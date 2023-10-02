package com.gfl.havryliuk.movies.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/page")
    public ModelAndView userInfo(ModelAndView modelAndView) {
//        log.trace("get:/movies/page");
//        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        modelAndView.addObject("user", user);
//        modelAndView.addObject("activePage", "myAccount");
//        modelAndView.addObject("subPage", "info");
        modelAndView.setViewName("customers");
        return modelAndView;
    }
}
