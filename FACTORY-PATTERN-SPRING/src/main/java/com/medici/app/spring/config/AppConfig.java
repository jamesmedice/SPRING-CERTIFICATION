package com.medici.app.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.medici.app.spring.factory.EmployeeAutowiringFactoryBean;
import com.medici.app.spring.factory.EmployeeFactoryBean;
import com.medici.app.spring.factory.SingleEmployeeFactory;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfig {

	@Value("${config.db.password}")
	private String password;

	@Value("${db.timer}")
	private String timer;

	@Bean("manager")
	public EmployeeFactoryBean getManager() {
		EmployeeFactoryBean factoryBean = new EmployeeFactoryBean();
		factoryBean.setDesignation("Manager");
		factoryBean.setPassword(password);
		return factoryBean;
	}

	@Bean("director")
	public EmployeeFactoryBean getDirector() {
		EmployeeFactoryBean factoryBean = new EmployeeFactoryBean();
		factoryBean.setDesignation("Director");
		factoryBean.setPassword(password);
		return factoryBean;
	}

	@Bean("single")
	public SingleEmployeeFactory getSingle() {
		SingleEmployeeFactory factoryBean = new SingleEmployeeFactory();
		factoryBean.setLastName("SLATER");
		factoryBean.setDesignation("Single");
		factoryBean.setPassword(password);
		return factoryBean;
	}

	@Bean("autowiring")
	public EmployeeAutowiringFactoryBean getAutowiring() {
		EmployeeAutowiringFactoryBean factoryBean = new EmployeeAutowiringFactoryBean();
		factoryBean.setSingleton(true);
		factoryBean.setPassword(password);
		return factoryBean;
	}

}
