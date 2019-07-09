package com.medici.app.spring.factory;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.medici.app.spring.model.Employee;

public class SingleEmployeeFactory extends AbstractFactoryBean<Employee> {

	private String designation;
	private String lastName;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Class<?> getObjectType() {
		return Employee.class;
	}

	@Override
	protected Employee createInstance() throws Exception {
		Employee employee = new Employee();
		employee.setId(-1);
		employee.setFirstName("dummy");
		employee.setLastName(lastName);
		employee.setDesignation(designation);
		employee.setPassword(password);
		return employee;
	}

}
