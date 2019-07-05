package com.medici.app.spring.facade.impl;

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
}
