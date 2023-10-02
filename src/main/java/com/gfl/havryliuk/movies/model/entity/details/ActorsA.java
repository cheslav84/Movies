//package com.gfl.havryliuk.movies.model.entity.details;
//
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//@Entity
//public class ActorsA extends MovieDetails{
//
//    @Column(nullable = false)
//    @ElementCollection
//    private Set<Actor> actors;
//
////    @Override
////    String showDetails() {
////        return details + ": " + actors.stream()
////                .map(Actor::toString)
////                .collect(Collectors.joining(", "));
////    }
//
//
//    @Override
//    public String toString() {
//        return super.toString() + actors.stream()
//                .map(Actor::toString)
//                .collect(Collectors.joining(", "));
//    }
//}
