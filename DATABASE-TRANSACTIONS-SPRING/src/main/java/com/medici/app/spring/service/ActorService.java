package com.medici.app.spring.service;

import com.medici.app.spring.model.Actor;

public interface ActorService {

	abstract Integer insert(Actor actor);

	abstract Actor loadById(Integer id);

	abstract Actor getById(Integer id);

	abstract void update(Actor actor);
}
