package com.gfl.havryliuk.movies.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

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

    @OneToMany(mappedBy = "rentalRecord", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Rental> rentals;

    @ElementCollection
    @CollectionTable(name = "MOVIE_NAME")
    @MapKeyColumn(name = "MOVIE_PAYMENT")
    @Column(name = "RECORDS")
    private Map<String, Double> records;

    private Double amountOwned;

    private Integer pointsEarned;
}
