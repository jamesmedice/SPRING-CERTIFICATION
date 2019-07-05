package com.medici.app.spring.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medici.app.spring.dao.EmployeeDao;
import com.medici.app.spring.facade.DateService;
import com.medici.app.spring.facade.EmployeeService;
import com.medici.app.spring.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private DateService dateService;

	@Autowired
	private EmployeeDao employeeDao;

	public void registerEmployee(Employee employee) {
		employee.setAssessmentDate(dateService.getNextAssessmentDate());
		employeeDao.saveInDatabase(employee);
	}

	public void mergeEmployee(Employee employee) {
		try {
			employee.setAssessmentDate(dateService.getNextAssessmentDate());
			employeeDao.updateEmployee(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Employee findEmploye(int employeeId) {
		return employeeDao.findEmployeeById(employeeId);

	}
	
	public List<Employee> allEmployees() {
		return employeeDao.findAll();
	}
}
