package com.gfl.havryliuk.movies.model.utils;

import com.gfl.havryliuk.movies.model.entity.RentalInfo;

public class PriceCalculator {


    public double calculatePrice(RentalInfo details, int daysRented) {
        if (details.isDailyWage()) {
            return getPricePerDay(details, daysRented);
        } else {
            return getPricePerRentalPeriod(details, daysRented);
        }
    }

    private double getPricePerDay(RentalInfo details, int daysRented) {
        return daysRented * details.getDailyPrice();
    }

    private double getPricePerRentalPeriod(RentalInfo details, int daysRented) {
        int allowedRentalDays = details.getAllowedRentalDays();

        double rentalPrice = details.getPeriodPrice();
        if (daysRented > allowedRentalDays) {
            rentalPrice += (daysRented - allowedRentalDays) * details.getPenalty();
        }
        return rentalPrice;
    }


}
