package com.gfl.havryliuk.movies.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Можна було б зробити цей клас абстрактний і застосувати "фабричний метод" і для кожного типу фільму розраховувати
 * свій Rental (наприклад RegulalRental, newReleaseRental). Але при цьому при додаванні кожного нового типу фільму
 * довелося б створювати новий конкретний клас Rental.
 * Натомість, для організації розрахунків створив окремий клас RentalDetails.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Rental {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private int daysRented;

    private boolean open;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID", nullable = false)
    private Movie movie;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(nullable = false)
    private LocalDate rentedDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;



}
