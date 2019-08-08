package com.medici.app.spring.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medici.app.spring.dao.JDBCActorDAO;
import com.medici.app.spring.mapper.ActorRowMapper;
import com.medici.app.spring.model.Actor;

@Repository
public class JDBCActorDAOImpl implements JDBCActorDAO {

	private static final String INSERT_INTO_ACTOR_VALUES = "INSERT INTO ACTOR (first_name,last_name,last_update) VALUES (?,?,?)";

	private static final String SELECT_FROM_ACTOR_WHERE_ID = "SELECT * FROM ACTOR WHERE ACTOR_ID = ?";

	private static final String SELECT_FROM_ACTOR_RANGE = "SELECT * FROM ACTOR  LIMIT  ? OFFSET  ?";

	private static final String DELETE_FROM_ACTOR_WHERE_ID = "DELETE FROM ACTOR WHERE ACTOR_ID = ?";

	private static final String SELECT_FROM_ACTOR = "SELECT * FROM ACTOR";

	private static final String UPDATE_QUERY = "UPDATE ACTOR SET first_name= ? ,last_name= ? ,last_update = ? WHERE ACTOR_ID = ?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void delete(int id) {
		System.out.println("query: " + DELETE_FROM_ACTOR_WHERE_ID);
		jdbcTemplate.update(DELETE_FROM_ACTOR_WHERE_ID, new Object[] { id });
	}

	public List<Actor> findByLimit(Integer limit, Integer offset) {
		System.out.println("query: " + SELECT_FROM_ACTOR_RANGE);
		return jdbcTemplate.query(SELECT_FROM_ACTOR_RANGE, new Object[] { limit, offset }, new ActorRowMapper());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Actor findById(int id) {
		System.out.println("query: " + SELECT_FROM_ACTOR_WHERE_ID);
		return (Actor) jdbcTemplate.queryForObject(SELECT_FROM_ACTOR_WHERE_ID, new Object[] { id }, new ActorRowMapper());

	}

	public int update(Integer actor_id, String first_name, String last_name) {
		return update(actor_id, first_name, last_name, null);
	}

	public int update(Integer actor_id, String first_name, String last_name, Date last_update) {
		return update(new Actor(actor_id, first_name, last_name, last_update));
	}

	public int update(Actor customer) {
		System.out.println("query: " + UPDATE_QUERY);
		return jdbcTemplate.update(UPDATE_QUERY, customer.getFirst_name(), customer.getLast_name(), customer.getLast_update(), customer.getActor_id());
	}

	public void insert(Actor target) {
		System.out.println("query: " + INSERT_INTO_ACTOR_VALUES);
		jdbcTemplate.update(INSERT_INTO_ACTOR_VALUES, new Object[] { target.getFirst_name(), target.getLast_name(), target.getLast_update() });
	}

	public void insertBatchSQL(final String sql) {
		jdbcTemplate.batchUpdate(new String[] { sql });

	}
}
