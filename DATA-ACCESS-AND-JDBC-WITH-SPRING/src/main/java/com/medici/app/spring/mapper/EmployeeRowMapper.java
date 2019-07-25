package com.medici.app.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medici.app.spring.model.Customer;

public class EmployeeRowMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomer_id(rs.getInt("customer_id"));
		customer.setStore_id(rs.getInt("store_id"));
		customer.setAddress_id(rs.getInt("address_id"));
		customer.setActive(rs.getBoolean("active"));
		customer.setEmail(rs.getString("email"));
		customer.setFirst_name(rs.getString("first_name"));
		customer.setLast_name(rs.getString("last_name"));
		customer.setCreate_date(rs.getDate("create_date"));
		customer.setLast_update(rs.getDate("last_update"));
		return customer;
	}
}
