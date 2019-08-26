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

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE, timeout = 1000)
	public Actor loadById(Integer id) {
		return actorDAO.loadById(id);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE, timeout = 1000)
	public Actor getById(Integer id) {
		return actorDAO.getById(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Integer insert(Actor actor) {
		return actorDAO.insert(actor);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void update(Actor actor) {
		Actor actorBean = actorDAO.getById(actor.getActor_id());
		actorBean.setFirst_name(actor.getFirst_name());
		actorBean.setLast_name(actor.getLast_name());
		actorBean.setLast_update(actor.getLast_update());

		actorDAO.update(actorBean);
	}

}
