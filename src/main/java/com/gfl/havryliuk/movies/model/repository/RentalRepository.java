package com.gfl.havryliuk.movies.model.repository;

import com.gfl.havryliuk.movies.model.entity.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends CrudRepository<Rental, String> {

}
