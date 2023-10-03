package com.gfl.havryliuk.movies.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RentalRecord {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToMany(mappedBy = "rentalRecord", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Rental> rentals;

    @ElementCollection
    @CollectionTable(name = "MOVIE_NAME")
    @MapKeyColumn(name = "MOVIE_PAYMENT")
    @Column(name = "RECORDS")
    private Map<String, Double> records = new HashMap<>();

    private Double price;

    private Integer pointsEarned;

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        records.forEach((key, value) -> builder.append(key).append(", "));

        String movies = builder.toString();
        return movies.substring(0, movies.lastIndexOf(","));



//        String customer = getRentals().get(0).getCustomer().getName();
//
//        StringBuilder builder = new StringBuilder();
//        records.forEach((key, value) -> builder.append("  ").append(key).append(":  ").append(value).append("\n"));
//
//        return "Rental Record for " + customer + "\n" +
//                builder +
//                "Amount owed is" + price + "\n" +
//                "You earned " + pointsEarned + " frequent renter points";
    }
}
