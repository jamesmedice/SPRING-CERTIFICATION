package com.medici.app.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.medici.app.spring.model.User;

@Configuration
@Profile("prod")
@PropertySource("classpath:application-prod.properties")
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfigProd {

	@Bean
	public User getUser() {
		return new User(100, "Prod User");
	}

}
