package com.medici.app.spring.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.medici.app.spring.dao.EmployeeDao;
import com.medici.app.spring.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	public void saveInDatabase(Employee employee) {

		System.out.println("Employee " + employee.getName() + " is registered for assessment on " + employee.getAssessmentDate());

	}

	public void updateEmployee(Employee employee) {

		throw new NullPointerException("ID not found");

	}

	public Employee findEmployeeById(int employeeId) {
		Employee employee = getEmployee();
		return employee;
	}

	public List<Employee> findAll() {
		Employee employee = getEmployee();
		return Arrays.asList(employee);
	}

	private Employee getEmployee() {
		Employee employee = new Employee();
		employee.setId(15);
		employee.setName("James Dean");
		return employee;
	}

}
