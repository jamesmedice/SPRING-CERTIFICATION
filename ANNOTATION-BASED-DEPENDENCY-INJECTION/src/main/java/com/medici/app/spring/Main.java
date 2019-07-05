package com.medici.app.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.facade.EmployeeService;
import com.medici.app.spring.life.cycle.MailService;
import com.medici.app.spring.model.Employee;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MailService mailService1 = context.getBean(MailService.class);
		System.out.println(mailService1.getProperties().toString());
		mailService1.send("james@dust.com");
		
		
		EmployeeService service = (EmployeeService) context.getBean("employeeService");
		Employee employee = new Employee();
		employee.setName("James Medici");
		service.registerEmployee(employee);

		context.close();
	}

}
