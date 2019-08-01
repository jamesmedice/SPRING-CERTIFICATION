package com.medici.app.spring.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.medici.app.spring.config.AppConfigTest;
import com.medici.app.spring.mapper.CustomerRowMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigTest.class)
public class JDBCCustomerDAOTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test(expected = IncorrectResultSizeDataAccessException.class)
	public void whenRetrievingMultipleValues_thenIncorrectResultSizeException() {
		jdbcTemplate.queryForObject("SELECT * FROM CUSTOMER  LIMIT  ? OFFSET  ?", new Integer[] { 2, 1 }, new CustomerRowMapper());
	}

	@Test(expected = BadSqlGrammarException.class)
	public void whenIncorrectSql_thenBadSqlGrammarException() {
		jdbcTemplate.queryForObject("SELECT * FROM CUSTOMER WHERE ID = ?", new Integer[] { 200 }, new CustomerRowMapper());
	}

	@Test(expected = IncorrectResultSetColumnCountException.class)
	public void whenRetrievingCustomer_thenIncorrectResultSetColumnCountException() {
		jdbcTemplate.queryForObject("SELECT * FROM CUSTOMER  WHERE CUSTOMER_ID = ? ", new Integer[] { 200 }, Integer.class);
	}
}
