package com.gfl.havryliuk.movies.controler;

import com.gfl.havryliuk.movies.model.entity.Customer;
import com.gfl.havryliuk.movies.model.entity.Movie;
import com.gfl.havryliuk.movies.model.service.CustomerService;
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
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ModelAndView getAllCustomers(ModelAndView modelAndView) {
        log.trace("get:/customers/all");
        modelAndView.addObject("customers", service.getAllCustomers());
        modelAndView.setViewName("customers");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getCustomer(@PathVariable String id, ModelAndView modelAndView) {
        log.trace("get:/customers/{}", id);
        modelAndView.addObject("customer", service.getCustomer(id));
        modelAndView.setViewName("customer-info");
        return modelAndView;
    }



    @GetMapping("/add")
    public ModelAndView addCustomerPage(ModelAndView modelAndView) {
        log.trace("get:/customers/add");
        modelAndView.addObject("customer", new Customer());
        modelAndView.setViewName("new-customer");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addCustomer(Customer customer, ModelAndView modelAndView) {
        log.trace("post:/customers/add");
        service.saveCustomer(customer);
        modelAndView.setViewName("redirect:/customers/" + customer.getId());
        return modelAndView;
    }
}
