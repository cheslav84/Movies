package com.gfl.havryliuk.movies.model.entity;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Можна було б зробити цей клас абстрактний і застосувати "фабричний метод" і для кожного типу фільму розраховувати
 * свій Rental (наприклад RegulalRental, newReleaseRental). Але при цьому при додаванні кожного нового типу фільму
 * довелося б створювати новий конкретний клас Rental.
 * Натомість, для організації розрахунків створив окремий клас RentalDetails.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Rental {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private Integer daysRented;

    private boolean open;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "MOVIE_ID", nullable = false)
    @JoinColumn(nullable = false)
    private Movie movie;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(nullable = false)
    private LocalDateTime rentedDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rental_record_id")
    private RentalRecord rentalRecord;





}
