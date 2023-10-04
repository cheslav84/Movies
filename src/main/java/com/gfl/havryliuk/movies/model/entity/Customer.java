package com.gfl.havryliuk.movies.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String name;

    private int frequentRenterPoint;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Rental> rentals;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (frequentRenterPoint != customer.frequentRenterPoint) return false;
        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        return name != null ? name.equals(customer.name) : customer.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + frequentRenterPoint;
        return result;
    }
}
