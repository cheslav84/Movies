package com.gfl.havryliuk.movies.model.entity.details;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@Entity
public class Actor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

//    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "actors")
    private Set<Actors> movieDetails = new HashSet<>();

    public Actor(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return name ;
    }
}
