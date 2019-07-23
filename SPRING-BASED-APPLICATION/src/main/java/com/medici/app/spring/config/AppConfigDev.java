package com.medici.app.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.medici.app.spring.model.User;

@Configuration
@Profile("dev")
@PropertySource("classpath:application-dev.properties")
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfigDev {

	@Bean
	public User getUser() {
		return new User(200, "Dev User");
	}

}
