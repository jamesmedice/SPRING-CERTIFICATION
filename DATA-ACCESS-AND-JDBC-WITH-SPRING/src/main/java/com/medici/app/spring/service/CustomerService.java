package com.medici.app.spring.service;

import java.util.List;

import com.medici.app.spring.model.Customer;

/**
 * 
 * @author TOSS
 *
 */
public interface CustomerService {

	abstract List<Customer> findByLimit(Integer limit, Integer offset);

	abstract List<Customer> findAll();

	abstract List<Customer> getAll();

	abstract Customer findById(Customer customer);

	abstract Customer findById(int id);

	abstract List<Customer> findByEmail(String email);

	abstract List<Customer> findByFullName(String firstName, String lastName);

	abstract int getMaxRows();

	abstract int getFetchSize();

	abstract void insert(Customer customer);

	abstract int update(Customer customer);

	abstract void insertBatch1(List<Customer> customers);
}
