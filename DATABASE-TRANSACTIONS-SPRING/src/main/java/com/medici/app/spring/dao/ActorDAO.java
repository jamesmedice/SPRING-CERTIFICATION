package com.medici.app.spring.dao;

import com.medici.app.spring.model.Actor;

public interface ActorDAO {

	public Integer insert(Actor actor);

	public Actor loadById(Integer id);

	public Actor getById(Integer id);

	public void update(Actor actor);
}
