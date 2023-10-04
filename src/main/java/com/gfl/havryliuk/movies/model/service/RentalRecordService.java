package com.gfl.havryliuk.movies.model.service;

import com.gfl.havryliuk.movies.model.entity.Customer;
import com.gfl.havryliuk.movies.model.entity.Rental;
import com.gfl.havryliuk.movies.model.entity.RentalInfo;
import com.gfl.havryliuk.movies.model.entity.RentalRecord;
import com.gfl.havryliuk.movies.model.report.Report;
import com.gfl.havryliuk.movies.model.report.ReportFactory;
import com.gfl.havryliuk.movies.model.report.html.HtmlReportFactory;
import com.gfl.havryliuk.movies.model.report.pdf.PdfReportFactory;
import com.gfl.havryliuk.movies.model.repository.CustomerRepository;
import com.gfl.havryliuk.movies.model.repository.RentalRecordRepository;
import com.gfl.havryliuk.movies.model.utils.PriceCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class RentalRecordService {
    private final RentalRecordRepository repository;
    private final CustomerRepository customerRepository;


    @Autowired
    public RentalRecordService(RentalRecordRepository repository, CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    public Iterable<RentalRecord> getAllRecords() {
        return repository.findAll();
    }

    public Report getReport(String reportType, String recordId) {
        RentalRecord record = repository.findById(recordId).orElseThrow();

        ReportFactory factory;
        switch (reportType){
            case "HTML" -> factory = new HtmlReportFactory();
            case "PDF" -> factory = new PdfReportFactory();
            default -> throw new IllegalArgumentException("There is no such report.");
        }
        return factory.createReport(record);
    }

    @Transactional
    public String createRecord(Customer customer) {


        RentalRecord record = new RentalRecord();
        List<Rental> rentals = customer.getRentals();
        Map<String, Double> records = record.getRecords();

        double price = 0;
        int rentalPoints = 0;

        for (Rental rental: rentals) {
            rental.setOpen(false);
            RentalInfo rentalInfo = rental.getMovie().getMovieType().getRentalInfo();
            PriceCalculator calculator = new PriceCalculator();
            double rentalPrice = calculator.calculatePrice(rentalInfo, rental.getDaysRented());

            records.put(rental.getMovie().getTitle(), rentalPrice);
            price += rentalPrice;

            rentalPoints++;
            if (rentalInfo.isBonus() && rental.getDaysRented() > rentalInfo.getRentalDaysForBonus()) {
                rentalPoints++;
            }
            rental.setCloseDate(LocalDateTime.now());
            rental.setRentalRecord(record);
        }

        record.setPrice(price);
        record.setPointsEarned(rentalPoints);

        int frequentRenterPoint = customer.getFrequentRenterPoint();
        frequentRenterPoint += rentalPoints;

        customer.setFrequentRenterPoint(frequentRenterPoint);

        RentalRecord saved = repository.save(record);
        return saved.getId();

    }


}
