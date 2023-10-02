package com.gfl.havryliuk.movies.model.repository;

import com.gfl.havryliuk.movies.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

}
