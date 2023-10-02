package com.gfl.havryliuk.movies.model.utils.printer;

import com.gfl.havryliuk.movies.model.entity.Rental;

import java.util.Set;

public interface Printer {
    void print(Set<Rental> rentals);
}
