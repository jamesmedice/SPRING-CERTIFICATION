package com.medici.app.spring.dao;

import java.util.List;

import com.medici.app.spring.model.Employee;

public interface EmployeeDao {

	void saveInDatabase(Employee employee);

	void updateEmployee(Employee employee);

	Employee findEmployeeById(int employeeId);

	List<Employee> findAll();
}
