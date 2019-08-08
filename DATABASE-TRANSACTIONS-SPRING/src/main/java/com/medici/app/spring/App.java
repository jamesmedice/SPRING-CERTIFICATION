package com.medici.app.spring;

import java.util.Calendar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.model.Actor;
import com.medici.app.spring.service.ActorService;

/**
 * 
 * @author a73s
 *
 */
public class App {
	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		ActorService service = context.getBean(ActorService.class);

		Actor actor = new Actor();
		actor.setFirst_name("ANDY");
		actor.setLast_name("IRONS");
		actor.setLast_update(Calendar.getInstance().getTime());
		Integer id = service.insert(actor);

		actor = service.getById(id);
		System.out.println(actor.toString());

		actor.setFirst_name("BRUCE");
		actor.setLast_update(Calendar.getInstance().getTime());
		service.update(actor);
		System.out.println(actor.toString());

		actor = service.loadById(id);
		System.out.println(actor.toString());

		context.close();

	}
}
