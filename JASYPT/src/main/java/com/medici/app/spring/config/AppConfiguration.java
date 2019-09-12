package com.medici.app.spring.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;

@Configuration
@EncryptablePropertySource("application.yml")
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfiguration {

	@Value("${config.db.password}")
	private String password;

	@Value("${db.timer}")
	private String timer;

	@PostConstruct
	public void getManager() {
		System.out.println("password: " + password);
		System.out.println("timer: " + timer);
	}

}
