package com.gfl.havryliuk.movies.model.entity;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class RentalInfo {

    private Double periodPrice;

    private Double dailyPrice;

    private Double penalty;

    private Integer allowedRentalDays;
    private boolean dailyWage;

    private boolean bonus;

    private Integer rentalDaysForBonus;


    public static class Builder {
        private final RentalInfo info;

        public Builder() {
            info = new RentalInfo();
        }

        public Builder withRentalPeriodPrice (double rentalPeriodPrice) {
            info.dailyPrice = rentalPeriodPrice;
            return this;
        }

        public Builder withRentalPerDayPrice (double rentalPerDayPrice) {
            info.dailyPrice = rentalPerDayPrice;
            return this;
        }

        public Builder withPenalty (double penalty) {
            info.penalty = penalty;
            return this;
        }

        public Builder withAllowedRentalDays (int allowedRentalDays) {
            info.allowedRentalDays = allowedRentalDays;
            return this;
        }

        public Builder withDailyWage (boolean dailyWage) {
            info.dailyWage = dailyWage;
            return this;
        }

        public RentalInfo build(){
            return info;
        }

    }

}
