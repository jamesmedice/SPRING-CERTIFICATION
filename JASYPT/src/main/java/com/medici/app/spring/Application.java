package com.medici.app.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfiguration;
import com.medici.app.spring.model.Employee;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public Application() {
		super();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

		Employee manager = (Employee) context.getBean("manager");
		System.out.println(manager.toString());
 
		System.out.println(System.getenv().values().toString());

		context.close();
	}
}
