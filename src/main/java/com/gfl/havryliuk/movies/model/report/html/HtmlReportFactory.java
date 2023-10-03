package com.gfl.havryliuk.movies.model.report.html;

import com.gfl.havryliuk.movies.model.entity.RentalRecord;
import com.gfl.havryliuk.movies.model.report.Report;
import com.gfl.havryliuk.movies.model.report.ReportFactory;

public class HtmlReportFactory extends ReportFactory {
    public Report createReport(RentalRecord record) {
        return new HtmlReport(record);
    }
}
