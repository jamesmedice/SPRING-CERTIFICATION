package com.medici.app.spring.service;

import java.util.List;

import com.medici.app.spring.model.Actor;

/**
 * 
 * @author TOSS
 *
 */
public interface ActorService {

	abstract List<Actor> findByLimit(Integer limit, Integer offset);

	abstract void insert(Actor actor);

	abstract Actor findById(int id);

	abstract int update(Actor actor);

}
