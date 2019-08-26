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

		Actor actor4Up = new Actor();
		actor4Up.setActor_id(id);
		actor4Up.setFirst_name("ANDY");
		actor4Up.setLast_name("SPRINGSTEEN");
		actor4Up.setLast_update(Calendar.getInstance().getTime());
		service.update(actor4Up);

		actor = service.loadById(id);
		System.out.println(actor.toString());

		context.close();

	}
}
