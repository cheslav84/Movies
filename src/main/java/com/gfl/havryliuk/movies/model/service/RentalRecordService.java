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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class RentalRecordService {

    @PersistenceContext
    private EntityManager em;

    private final RentalRecordRepository repository;
    private final CustomerRepository customerRepository;
    private final PriceCalculator calculator;



    @Autowired
    public RentalRecordService(RentalRecordRepository repository, CustomerRepository customerRepository,
                               PriceCalculator calculator) {
        this.repository = repository;
        this.customerRepository = customerRepository;
        this.calculator = calculator;
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
    public String createRecord(Customer customerDetached) {

        Customer customer = customerRepository.findById(customerDetached.getId()).orElseThrow();
        em.merge(customer);//todo ask for better decision

        RentalRecord record = new RentalRecord();
        List<Rental> rentals = customerDetached.getRentals();
        Map<String, Double> records = record.getRecords();

        double price = 0;
        int rentalPoints = 0;

        for (Rental rental: rentals) {
            rental.setOpen(false);
            RentalInfo rentalInfo = rental.getMovie().getMovieType().getRentalInfo();

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

        int frequentRenterPoint = customerDetached.getFrequentRenterPoint();
        frequentRenterPoint += rentalPoints;
        customer.setFrequentRenterPoint(frequentRenterPoint);

        RentalRecord saved = repository.save(record);
        return saved.getId();

    }


}
