package com.medici.app.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.medici.app.spring.dao.ActorDAO;
import com.medici.app.spring.model.Actor;

@Repository
public class ActorDAOImpl extends HibernateDAO implements ActorDAO {

	@Override
	public Integer insert(Actor actor) {
		return (Integer) getSession().save(actor);
	}

	@Override
	public Actor loadById(Integer id) {
		return getSession().load(Actor.class, id);
	}

	@Override
	public Actor getById(Integer id) {
		return getSession().get(Actor.class, id);
	}

	@Override
	public void update(Actor actor) {
		getSession().saveOrUpdate(actor);
	}

}
