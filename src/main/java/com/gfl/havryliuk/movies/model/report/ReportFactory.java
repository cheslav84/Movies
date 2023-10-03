package com.gfl.havryliuk.movies.model.report;

import com.gfl.havryliuk.movies.model.entity.RentalRecord;

public abstract class ReportFactory {
    public abstract Report createReport(RentalRecord record);
}
