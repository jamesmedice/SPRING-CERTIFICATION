package com.medici.app.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.facade.DirectorService;
import com.medici.app.spring.life.cycle.SmtpService;
import com.medici.app.spring.model.Director;

/**
 * 
 * @author a73s
 *
 */
public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		try {
			SmtpService mailService1 = context.getBean(SmtpService.class);
			System.out.println(mailService1.getProperties().toString());
			System.out.println(mailService1.getTree().toString());
			mailService1.send("medice@dust.com");
			mailService1.throwIllegalArgument("[exception]");
		} catch (Exception e) {
		}

		DirectorService service = (DirectorService) context.getBean("directorService");
		Director director = new Director();
		director.setName("James Medici");
		service.registerDirector(director);
		director.setName(" Medici hoffeinhein");
		service.mergeDirector(director);
		service.findDirectorById(10);
		service.findAll();

		context.close();
	}
}
