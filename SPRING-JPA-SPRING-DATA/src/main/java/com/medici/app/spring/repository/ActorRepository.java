package com.medici.app.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.medici.app.spring.model.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

	List<Actor> findByFirstName(String name);
}
