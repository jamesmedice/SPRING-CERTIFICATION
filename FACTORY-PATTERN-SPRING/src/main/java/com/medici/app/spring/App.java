package com.medici.app.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.model.Employee;

public class App {
	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Employee manager = (Employee) context.getBean("manager");
		System.out.println(manager.toString());

		Employee director = (Employee) context.getBean("director");
		System.out.println(director.toString());

		Employee single = (Employee) context.getBean("single");
		System.out.println(single.toString());

		Employee autowiring = (Employee) context.getBean("autowiring");
		System.out.println(autowiring.toString());

		context.close();
	}
}
