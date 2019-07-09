package com.medici.app.spring.factory;

import com.medici.app.spring.model.Employee;

public class EmployeeAutowiringFactoryBean extends AbstractAutowiringFactoryBean<Employee> {

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	protected Employee baseCreateInstance() {
		Employee employee = new Employee();
		employee.setId(-1);
		employee.setFirstName("Autowiring");
		employee.setLastName("Autowiring");
		employee.setDesignation("Autowiring");
		employee.setPassword(password);
		return employee;
	}

}
