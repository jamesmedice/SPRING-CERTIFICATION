package com.medici.app.spring.factory;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.medici.app.spring.model.Employee;

public class EmployeeFactoryBean extends AbstractFactoryBean<Object> {

	private String designation;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	protected Object createInstance() throws Exception {
		Employee employee = new Employee();
		employee.setId(-1);
		employee.setFirstName("dummy");
		employee.setLastName("dummy");
		employee.setDesignation(designation);
		return employee;
	}

	@Override
	public Class<Employee> getObjectType() {
		return Employee.class;
	}

}
