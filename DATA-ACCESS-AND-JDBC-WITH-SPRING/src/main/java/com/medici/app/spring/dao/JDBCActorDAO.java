package com.medici.app.spring.dao;

import java.util.Date;
import java.util.List;

import com.medici.app.spring.model.Actor;

/**
 * 
 * @author TOSS
 *
 */
public interface JDBCActorDAO {

	public void delete(int id);

	public List<Actor> findByLimit(Integer limit, Integer offset);

	public void insert(Actor actor);

	public Actor findById(int id);

	public int update(Actor actor);

	public int update(Integer actor_id, String first_name, String last_name);

	public int update(Integer actor_id, String first_name, String last_name, Date last_update);

}
