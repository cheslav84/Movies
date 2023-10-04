package com.gfl.havryliuk.movies.controler;

import com.gfl.havryliuk.movies.model.entity.Customer;
import com.gfl.havryliuk.movies.model.entity.Rental;
import com.gfl.havryliuk.movies.model.report.Report;
import com.gfl.havryliuk.movies.model.service.RentalRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/records")
public class RentalRecordController {

    private final RentalRecordService service;


    @Autowired
    public RentalRecordController(RentalRecordService service) {
        this.service = service;
    }

    @GetMapping("/pdf/{id}")
        public void getCustomerPdfReport(@PathVariable String id, HttpServletResponse response) throws IOException {
        log.trace("get:/records/pdf/{}", id);

        Report report = service.getReport("PDF", id);
        ByteArrayOutputStream reportStream = report.getReport();

        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setContentType("application/pdf");
        response.setContentLength(reportStream.size());
        OutputStream os = response.getOutputStream();
        reportStream.writeTo(os);
        os.flush();
        os.close();
    }



    @GetMapping("/{id}")
    public ModelAndView getCustomerReport(@PathVariable String id, ModelAndView modelAndView) {
        log.trace("get:/records/{}", id);
        Report report = service.getReport("HTML", id);
        ByteArrayOutputStream reportStream = report.getReport();
        modelAndView.addObject("report", reportStream.toString());
        modelAndView.setViewName("customer-record-info");
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView getAllRecords(ModelAndView modelAndView) {
        log.trace("get:/records/all");
        modelAndView.addObject("records", service.getAllRecords());
        modelAndView.setViewName("records");
        return modelAndView;
    }


    @PostMapping("/add/customers/{id}")
    public ModelAndView addRentalRecord(@PathVariable String id, Customer customer, ModelAndView modelAndView) {
        log.trace("post:/records/add/customers/{}", id);
        if (customer.getRentals() != null) {
            String recordId = service.createRecord(customer);
            modelAndView.setViewName("redirect:/records/" + recordId);
        } else {
            modelAndView.setViewName("redirect:/records/all");
        }
        return modelAndView;
    }

}