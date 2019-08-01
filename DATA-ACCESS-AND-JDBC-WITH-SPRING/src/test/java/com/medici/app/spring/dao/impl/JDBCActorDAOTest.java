package com.medici.app.spring.dao.impl;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.medici.app.spring.config.AppConfigTest;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigTest.class)
public class JDBCActorDAOTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String INSERT_INTO_ACTOR_VALUES = "INSERT INTO ACTOR (Actor_id, first_name,last_name,last_update) VALUES (?,?,?,?)";

	@Test(expected = DuplicateKeyException.class)
	public void whenInsertingActor_thenDuplicateKeyException() {
		jdbcTemplate.update(INSERT_INTO_ACTOR_VALUES, new Object[] { 20, "Martin", "Trump", Calendar.getInstance().getTime() });
	}

}
