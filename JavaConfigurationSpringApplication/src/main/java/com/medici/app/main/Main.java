package com.medici.app.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.medici.app.config.AppConfig;
import com.medici.app.event.CustomEventPublisher;
import com.medici.app.service.Manager;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);

		ctx.refresh();
		ctx.start();

		Manager manager = (Manager) ctx.getBean("managerService");
		System.out.println(manager.getServiceName());

		CustomEventPublisher customEventPublisher = (CustomEventPublisher) ctx.getBean("customEventPublisher");
		customEventPublisher.publish();

		ctx.stop();
	}
}
