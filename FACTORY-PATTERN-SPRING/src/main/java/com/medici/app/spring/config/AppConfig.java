package com.medici.app.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.medici.app.spring.factory.EmployeeAutowiringFactoryBean;
import com.medici.app.spring.factory.EmployeeFactoryBean;
import com.medici.app.spring.factory.SingleEmployeeFactory;

@Configuration
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfig {

	@Bean("manager")
	public EmployeeFactoryBean getManager() {
		EmployeeFactoryBean manager = new EmployeeFactoryBean();
		manager.setDesignation("Manager");
		return manager;
	}

	@Bean("director")
	public EmployeeFactoryBean getDirector() {
		EmployeeFactoryBean manager = new EmployeeFactoryBean();
		manager.setDesignation("Director");
		return manager;
	}

	@Bean("single")
	public SingleEmployeeFactory getSingle() {
		SingleEmployeeFactory single = new SingleEmployeeFactory();
		single.setLastName("SLATER");
		single.setDesignation("Single");
		return single;
	}

	@Bean("autowiring")
	public EmployeeAutowiringFactoryBean getAutowiring() {
		EmployeeAutowiringFactoryBean autowiring = new EmployeeAutowiringFactoryBean();
		return autowiring;
	}

}
