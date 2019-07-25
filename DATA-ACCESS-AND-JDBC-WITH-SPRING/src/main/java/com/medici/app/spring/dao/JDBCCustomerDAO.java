package com.medici.app.spring.dao;

import java.util.Date;
import java.util.List;

import com.medici.app.spring.model.Customer;

/**
 * 
 * @author TOSS
 *
 */
public interface JDBCCustomerDAO {

	public void insert(Customer customer);

	public Customer findById(int id);

	public List<Customer> getAll();

	public List<Customer> findAll();

	public int getMaxRows();

	public int getFetchSize();

	public void insertBatch1(final List<Customer> customers);

	public void insertBatch2(final String sql);

	public int update(Customer customer);

	public int update(Integer customer_id, Integer store_id, String first_name, String last_name, String email, Integer address_id, Boolean active, Date create_date);

	public int update(Integer customer_id, Integer store_id, String first_name, String last_name, String email, Integer address_id, Boolean active, Date create_date, Date last_update);
}
