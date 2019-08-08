package com.medici.app.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medici.app.spring.model.Actor;

public class ActorRowMapper implements RowMapper<Actor> {

	public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Actor actor = new Actor();
		actor.setActor_id(rs.getInt("actor_id"));
		actor.setFirst_name(rs.getString("first_name"));
		actor.setLast_name(rs.getString("last_name"));
		actor.setLast_update(rs.getDate("last_update"));
		return actor;
	}
}
