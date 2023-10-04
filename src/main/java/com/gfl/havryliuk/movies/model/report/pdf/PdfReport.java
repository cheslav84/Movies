package com.gfl.havryliuk.movies.model.report.pdf;

import com.gfl.havryliuk.movies.model.entity.RentalRecord;
import com.gfl.havryliuk.movies.model.report.Report;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.Map;


public class PdfReport implements Report {

    private final RentalRecord record;

    public PdfReport(RentalRecord record) {
        this.record = record;
    }

    @Override
    public ByteArrayOutputStream getReport() {
        Document document = new Document();
        ByteArrayOutputStream report = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, report);
            document.open();
            writePdf(document);
        } catch (DocumentException e) {
            throw new IllegalArgumentException(e);
        }
        document.close();

        return report;
    }

    private void writePdf(Document document) throws DocumentException {
        String customer = record.getRentals().get(0).getCustomer().getName();
        Map<String, Double> records = record.getRecords();
        document.add(new Paragraph("Rental Record for " + customer));
        for (Map.Entry<String, Double> record : records.entrySet()) {
            document.add(new Paragraph("    " + record.getKey() + ": " + record.getValue()));
        }
        document.add(new Paragraph("Amount owed is " + record.getPrice()));
        document.add(new Paragraph("You earned " + record.getPointsEarned()));
    }
}
