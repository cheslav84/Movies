package com.gfl.havryliuk.movies.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Клас може конструюватись з різними наборами вхідних даних, деякі поля можуть бути null. Тому вирішено застосувати
 * "Builder".
 *
 */

@Getter
@Setter
@Embeddable
public class RentalInfo {

    @Column(nullable = true)
    private Double periodPrice;

    @Column(nullable = true)
    private Double dailyPrice;

    @Column(nullable = true)
    private Double penalty;

    @Column(nullable = true)
    private Integer allowedRentalDays;
    private boolean dailyWage;


    public static class Builder {
        private RentalInfo info;

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
