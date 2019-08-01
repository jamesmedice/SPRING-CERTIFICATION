package com.medici.app.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.medici.app.spring.dao.JDBCCustomerDAO;
import com.medici.app.spring.model.Customer;
import com.medici.app.spring.service.CustomerService;

/**
 * 
 * @author TOSS
 *
 */
@Service
@CacheConfig(cacheNames = { "customer" })
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	JDBCCustomerDAO jdbcEmployeeDAO;

	@Cacheable("customer.limit")
	public List<Customer> findByLimit(Integer limit, Integer offset) {
		return jdbcEmployeeDAO.findByLimit(limit, offset);
	}

	public List<Customer> getAll() {
		return jdbcEmployeeDAO.getAll();
	}

	public List<Customer> findAll() {
		return jdbcEmployeeDAO.findAll();
	}

	@Cacheable(value = "customer.findById", key = "#customer.customer_id", condition = "#customer.customer_id < 10")
	public Customer findById(Customer customer) {
		return jdbcEmployeeDAO.findById(customer.getCustomer_id());
	}

	@Cacheable(value = "customer.findById", condition = "#id > 20500")
	public Customer findById(int id) {
		return jdbcEmployeeDAO.findById(id);
	}

	@Cacheable(value = "customer.findByEmail", unless = "#result.size() > 35")
	public List<Customer> findByEmail(String email) {
		return jdbcEmployeeDAO.findByEmail(email);
	}

	@Cacheable(value = "customer.findByFullName", key = "#firstName", sync = true)
	public List<Customer> findByFullName(String firstName, String lastName) {
		return jdbcEmployeeDAO.findByFullName(firstName, lastName);
	}

	public int getMaxRows() {
		return jdbcEmployeeDAO.getMaxRows();
	}

	public int getFetchSize() {
		return jdbcEmployeeDAO.getFetchSize();
	}

	public void insertBatch1(List<Customer> customers) {
		jdbcEmployeeDAO.insertBatch1(customers);
	}

	public void insert(Customer customer) {
		jdbcEmployeeDAO.insert(customer);
	}

	@CachePut(value = "customer.findById")
	public int update(Customer customer) {
		return jdbcEmployeeDAO.update(customer);
	}

}
