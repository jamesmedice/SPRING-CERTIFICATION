package com.medici.app.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.medici.app.spring.model.Employee;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;

@Configuration
@EncryptablePropertySource("application.yml")
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfiguration {

	@Value("${config.db.password}")
	private String password;

	@Value("${db.timer}")
	private String timer;

	@Bean("manager")
	public Employee getManager() {
		Employee factoryBean = new Employee();
		factoryBean.setDesignation(timer);
		factoryBean.setPassword(password);
		return factoryBean;
	}

}
