package com.medici.app.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.medici.app.spring.dao.ActorDAO;
import com.medici.app.spring.model.Actor;
import com.medici.app.spring.service.ActorService;

/**
 * 
 * @author TOSS
 *
 */
@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	ActorDAO actorDAO;

	@Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 1000)
	public Integer insert(Actor actor) {
		return actorDAO.insert(actor);
	}

	@Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE)
	public Actor loadById(Integer id) {
		return actorDAO.loadById(id);
	}

	@Transactional(readOnly = true)
	public Actor getById(Integer id) {
		return actorDAO.getById(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 1000)
	public void update(Actor actor) {
		actorDAO.update(actor);
	}

}
