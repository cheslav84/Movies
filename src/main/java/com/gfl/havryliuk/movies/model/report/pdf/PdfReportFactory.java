package com.gfl.havryliuk.movies.model.report.pdf;

import com.gfl.havryliuk.movies.model.entity.RentalRecord;
import com.gfl.havryliuk.movies.model.report.Report;
import com.gfl.havryliuk.movies.model.report.ReportFactory;

public class PdfReportFactory extends ReportFactory {
    public Report createReport(RentalRecord record) {
        return new PdfReport(record);
    }
}
