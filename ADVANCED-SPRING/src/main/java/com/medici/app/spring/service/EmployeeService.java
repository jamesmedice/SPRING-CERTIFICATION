package com.medici.app.spring.service;

import java.util.Calendar;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.medici.app.spring.model.Employee;

public class EmployeeService implements InitializingBean, DisposableBean {

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeService() {
		System.out.println("EmployeeService no-args constructor called");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy EmployeeService Closing resources");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet EmployeeService initializing to dummy value");

		if (employee.getName() == null)
			employee.setName("Pankaj_" + Calendar.getInstance().getTimeInMillis());

	}

}
