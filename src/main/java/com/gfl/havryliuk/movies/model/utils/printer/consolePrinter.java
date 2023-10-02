package com.gfl.havryliuk.movies.model.utils.printer;

import com.gfl.havryliuk.movies.model.entity.Rental;

import java.util.Set;

public class consolePrinter implements Printer {

    @Override
    public void print(Set<Rental> rentals) {

//        double totalAmount = 0;
//        int frequentRenterPoints = 0;
//        String result = "Rental Record for " + getName() + "\n";
//        for (Rental each : rentals) {
//            double thisAmount = 0;
//            //determine amounts for each line
//            switch (each.getMovie().getPriceCode()) {
//                case REGULAR -> {
//                    thisAmount += 2;
//                    if (each.getDaysRented() > 2)
//                        thisAmount += (each.getDaysRented() - 2) * 1.5;
//                }
//                case NEW_RELEASE -> thisAmount += each.getDaysRented() * 3;
//                case CHILDRENS -> {
//                    thisAmount += 1.5;
//                    if (each.getDaysRented() > 3)
//                        thisAmount += (each.getDaysRented() - 3) * 1.5;
//                }
//            }
//            // add frequent renter points
//            frequentRenterPoints++;
//            // add bonus for a two day new release rental
//            if ((each.getMovie().getPriceCode() == NEW_RELEASE) && each.getDaysRented() > 1)
//                frequentRenterPoints++;
//            //show figures for this rental
//            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
//            totalAmount += thisAmount;
//        }
//        //add footer lines
//        result += "Amount owed is " + totalAmount + "\n";
//        result += "You earned " + frequentRenterPoints + " frequent renter points";
//        return result;






    }
}
