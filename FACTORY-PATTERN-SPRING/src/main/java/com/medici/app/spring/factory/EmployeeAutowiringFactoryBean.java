package com.medici.app.spring.factory;

import com.medici.app.spring.model.Employee;

public class EmployeeAutowiringFactoryBean extends AbstractAutowiringFactoryBean<Employee> {

	@Override
	protected Employee baseCreateInstance() {
		Employee employee = new Employee();
		employee.setId(-1);
		employee.setFirstName("Autowiring");
		employee.setLastName("Autowiring");
		employee.setDesignation("Autowiring");
		return employee;
	}

}
