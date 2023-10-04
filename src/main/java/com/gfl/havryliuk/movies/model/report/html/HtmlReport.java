package com.gfl.havryliuk.movies.model.report.html;

import com.gfl.havryliuk.movies.model.entity.RentalRecord;
import com.gfl.havryliuk.movies.model.report.Report;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HtmlReport implements Report {

    private final ByteArrayOutputStream report;

    public HtmlReport(RentalRecord record) {

        String customer = record.getRentals().get(0).getCustomer().getName();

        StringBuilder builder = new StringBuilder();
        record.getRecords()
                .forEach((key, value) -> builder
                        .append("<div style=\"margin-left: 30px;\">  ")
                        .append(key).append(": ")
                        .append(value).append("</div>"));

        String html = "<div style=\"width: 300px; text-align: left;\">" +
                "<div>Rental Record for " + customer + "</div>" +
                builder +
                "<div>Amount owed is " + record.getPrice() + "</div>" +
                "<div>You earned " + record.getPointsEarned() + " frequent renter points</div>" +
                "</div>";
        report = new ByteArrayOutputStream();
        try {
            report.write(html.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return report.toString();
    }

    @Override
    public ByteArrayOutputStream getReport() {
        return report;
    }
}
