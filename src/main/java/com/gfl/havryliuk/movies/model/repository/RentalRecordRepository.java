package com.gfl.havryliuk.movies.model.repository;

import com.gfl.havryliuk.movies.model.entity.RentalRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRecordRepository extends CrudRepository<RentalRecord, String> {

}
