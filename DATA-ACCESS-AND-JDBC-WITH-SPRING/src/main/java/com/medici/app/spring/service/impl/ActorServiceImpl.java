package com.medici.app.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.medici.app.spring.dao.JDBCActorDAO;
import com.medici.app.spring.model.Actor;
import com.medici.app.spring.service.ActorService;

/**
 * 
 * @author TOSS
 *
 */
@Service
@CacheConfig(cacheNames = { "actor" })
public class ActorServiceImpl implements ActorService {

	@Autowired
	JDBCActorDAO jdbcActorDAO;

	@Cacheable("actor.limit")
	public List<Actor> findByLimit(Integer limit, Integer offset) {
		return jdbcActorDAO.findByLimit(limit, offset);
	}

	@Cacheable(value = "actor.findById", condition = "#id > 150")
	public Actor findById(int id) {
		return jdbcActorDAO.findById(id);
	}

	@CacheEvict(value = "actor.limit", allEntries = true)
	public void insert(Actor actor) {
		jdbcActorDAO.insert(actor);
	}

	@CachePut(value = "actor.findById")
	public int update(Actor actor) {
		return jdbcActorDAO.update(actor);
	}

}
