package com.medici.app.spring.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medici.app.spring.dao.JDBCCustomerDAO;
import com.medici.app.spring.mapper.CustomerRowMapper;
import com.medici.app.spring.model.Customer;
import com.medici.app.spring.utils.QueryContants;

@Repository
public class JDBCCustomerDAOImpl implements JDBCCustomerDAO {

	private static final String INSERT_INTO_CUSTOMER_VALUES = "INSERT INTO  CUSTOMER (store_id,first_name,last_name,email,address_id,active,create_date,last_update)VALUES(?,?,?,?,?,?,?,?)";

	private static final String SELECT_NAME_FROM_CUSTOMER_WHERE_ID = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";

	private static final String SELECT_NAME_FROM_CUSTOMER_RANGE = "SELECT * FROM CUSTOMER  LIMIT  ? OFFSET  ?";

	private static final String SELECT_FROM_CUSTOMER = "SELECT * FROM CUSTOMER";

	private static final String SELECT_FROM_CUSTOMER_BY_EMAIL = "SELECT * FROM CUSTOMER WHERE EMAIL LIKE ?";

	private static final String SELECT_FROM_CUSTOMER_BY_NAME = "SELECT * FROM CUSTOMER WHERE FIRST_NAME LIKE ? AND LAST_NAME LIKE ?";

	private static final String UPDATE_QUERY = "UPDATE CUSTOMER SET store_id= ? ,first_name= ? ,last_name= ? ,email= ? ,address_id = ? ,active = ?,create_date = ?,last_update = ? WHERE CUSTOMER_ID = ?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Customer> findByLimit(Integer limit, Integer offset) {
		System.out.println("query: " + SELECT_NAME_FROM_CUSTOMER_RANGE);
		return jdbcTemplate.query(SELECT_NAME_FROM_CUSTOMER_RANGE, new Object[] { limit, offset }, new CustomerRowMapper());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Customer findById(int id) {
		System.out.println("query: " + SELECT_NAME_FROM_CUSTOMER_WHERE_ID);
		return (Customer) jdbcTemplate.queryForObject(SELECT_NAME_FROM_CUSTOMER_WHERE_ID, new Object[] { id }, new CustomerRowMapper());

	}

	public List<Customer> findByEmail(String email) {
		System.out.println("query: " + SELECT_FROM_CUSTOMER_BY_EMAIL);
		return jdbcTemplate.query(SELECT_FROM_CUSTOMER_BY_EMAIL, new String[] { QueryContants.PERCENTAGE + email + QueryContants.PERCENTAGE }, new CustomerRowMapper());
	}

	public List<Customer> findByFullName(String firstName, String lastName) {
		System.out.println("query: " + SELECT_FROM_CUSTOMER_BY_NAME);
		return jdbcTemplate.query(SELECT_FROM_CUSTOMER_BY_NAME, new String[] { QueryContants.PERCENTAGE + firstName + QueryContants.PERCENTAGE, QueryContants.PERCENTAGE + lastName + QueryContants.PERCENTAGE },
				new CustomerRowMapper());
	}

	public List<Customer> getAll() {
		return jdbcTemplate.query(SELECT_FROM_CUSTOMER, new CustomerRowMapper());
	}

	@SuppressWarnings("rawtypes")
	public List<Customer> findAll() {

		List<Customer> customers = new ArrayList<Customer>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_FROM_CUSTOMER);
		for (Map row : rows) {
			Customer target = new Customer();
			target.setCustomer_id(((Integer) row.get("CUSTOMER_id")));
			target.setActive((Boolean) row.get("active"));
			target.setAddress_id((Integer) row.get("address_id"));
			target.setCreate_date((Date) row.get("create_date"));
			target.setEmail((String) row.get("email"));
			target.setFirst_name((String) row.get("first_name"));
			target.setLast_name((String) row.get("last_name"));
			target.setLast_update((Date) row.get("last_update"));
			target.setStore_id((Integer) row.get("store_id"));
			customers.add(target);
		}

		return customers;
	}

	public int update(Integer customer_id, Integer store_id, String first_name, String last_name, String email, Integer address_id, Boolean active, Date create_date) {
		return update(customer_id, store_id, first_name, last_name, email, address_id, active, create_date, null);
	}

	public int update(Integer customer_id, Integer store_id, String first_name, String last_name, String email, Integer address_id, Boolean active, Date create_date, Date last_update) {
		return update(new Customer(customer_id, store_id, first_name, last_name, email, address_id, active, create_date, last_update));
	}

	public int update(Customer customer) {
		return jdbcTemplate.update(UPDATE_QUERY, customer.getStore_id(), customer.getFirst_name(), customer.getLast_name(), customer.getEmail(), customer.getAddress_id(), customer.getActive(), customer.getCreate_date(),
				customer.getLast_update(), customer.getCustomer_id());
	}

	public void insert(Customer target) {
		jdbcTemplate.update(INSERT_INTO_CUSTOMER_VALUES, new Object[] { target.getStore_id(), target.getFirst_name(), target.getLast_name() });
	}

	public void insertBatchSQL(final String sql) {
		jdbcTemplate.batchUpdate(new String[] { sql });

	}

	public void insertBatch1(final List<Customer> customers) {

		jdbcTemplate.batchUpdate(INSERT_INTO_CUSTOMER_VALUES, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// address_id,active,create_date,last_update
				Customer target = customers.get(i);
				ps.setInt(1, target.getStore_id());
				ps.setString(2, target.getFirst_name());
				ps.setString(3, target.getLast_name());
				ps.setString(4, target.getEmail());
				ps.setInt(5, target.getAddress_id());
				ps.setBoolean(6, target.getActive());
				ps.setDate(7, new java.sql.Date(target.getCreate_date().getTime()));
				ps.setDate(8, new java.sql.Date(target.getLast_update().getTime()));
			}

			public int getBatchSize() {
				return customers.size();
			}
		});
	}

	public void insertBatch2(final String sql) {
		jdbcTemplate.batchUpdate(new String[] { sql });

	}

	public int getMaxRows() {
		return jdbcTemplate.getMaxRows();
	}

	public int getFetchSize() {
		return jdbcTemplate.getFetchSize();
	}

}
