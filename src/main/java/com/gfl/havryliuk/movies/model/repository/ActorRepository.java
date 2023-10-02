package com.gfl.havryliuk.movies.model.repository;

import com.gfl.havryliuk.movies.model.entity.details.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends CrudRepository<Actor, String> {
    Optional<Actor> findByName(String name);

}
