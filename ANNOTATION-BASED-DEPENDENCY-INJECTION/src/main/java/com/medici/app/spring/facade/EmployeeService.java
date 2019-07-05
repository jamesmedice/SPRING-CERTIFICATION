package com.medici.app.spring.facade;

import java.util.List;

import com.medici.app.spring.model.Employee;

public interface EmployeeService {

	void registerEmployee(Employee employee);

	void mergeEmployee(Employee employee);

	Employee findEmploye(int employeeId);

	List<Employee> allEmployees();
}
