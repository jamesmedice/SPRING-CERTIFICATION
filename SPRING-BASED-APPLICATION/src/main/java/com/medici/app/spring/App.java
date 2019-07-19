package com.medici.app.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;

/**
 * 
 * @author a73s
 *
 */
public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		context.close();
	}
}
