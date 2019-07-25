package com.medici.app.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	JDBCCustomerDAO jdbcEmployeeDAO;

	public List<Customer> getAll() {
		return jdbcEmployeeDAO.getAll();
	}

	public List<Customer> findAll() {
		return jdbcEmployeeDAO.findAll();
	}

	public Customer findById(int id) {
		return jdbcEmployeeDAO.findById(id);
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

	@Override
	public int update(Customer customer) {
		return jdbcEmployeeDAO.update(customer);
	}

}
