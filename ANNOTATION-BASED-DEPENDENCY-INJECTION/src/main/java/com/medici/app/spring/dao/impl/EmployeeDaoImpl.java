package com.medici.app.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.medici.app.spring.dao.EmployeeDao;
import com.medici.app.spring.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	public void saveInDatabase(Employee employee) {

		System.out.println("Employee " + employee.getName() + " is registered for assessment on " + employee.getAssessmentDate());

	}

}
