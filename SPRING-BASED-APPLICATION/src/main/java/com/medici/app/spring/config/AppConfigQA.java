package com.medici.app.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.medici.app.spring.model.User;

@Configuration
@Profile("qa")
@PropertySource("classpath:application-qa.properties")
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfigQA {

	@Bean
	public User getUser() {
		return new User(100, "QA User");
	}

}
