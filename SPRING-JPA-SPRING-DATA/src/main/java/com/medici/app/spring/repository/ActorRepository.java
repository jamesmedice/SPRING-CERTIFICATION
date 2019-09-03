package com.medici.app.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medici.app.spring.model.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
