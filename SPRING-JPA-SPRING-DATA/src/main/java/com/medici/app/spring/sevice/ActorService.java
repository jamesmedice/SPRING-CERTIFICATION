package com.medici.app.spring.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medici.app.spring.model.Actor;
import com.medici.app.spring.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	ActorRepository repository;

	public Actor save(Actor actor) {
		return repository.save(actor);
	}

	public Iterable<Actor> findAll() {
		return repository.findAll();
	}

	public List<Actor> findByFirstName(String name) {
		return repository.findByFirstName(name);
	}

	public boolean existsById(Integer id) {
		return repository.existsById(id);
	}

	public Optional<Actor> findById(Integer id) {
		return repository.findById(id);
	}

}
