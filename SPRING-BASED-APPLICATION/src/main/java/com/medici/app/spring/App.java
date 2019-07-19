package com.medici.app.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.dao.MovieDao;
import com.medici.app.spring.service.MusicService;
import com.medici.app.spring.service.impl.MusicServiceIml;

/**
 * 
 * @author a73s
 *
 */
public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MovieDao obj = (MovieDao) context.getBean("movieDao");

		System.out.println("Calling - 1 , Request dummy :  " + obj.findByDirector("dummy"));
		System.out.println("Calling - 2 , Request dummy :  " + obj.findByDirector("dummy"));
		System.out.println("Calling - 3 , Request dummy :  " + obj.findByDirector("dummy"));
		System.out.println("Calling - 4 , Request dummies :  " + obj.findByDirector("dummies"));

		MusicService musicService = context.getBean(MusicService.class);
		String service = MusicServiceIml.class.getSimpleName();

		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.println("Calling: " + service + ".findAll();");
		System.out.println("Occurrences: " + musicService.findAll());
		System.out.println("Occurrences: " + musicService.findAll());

		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.println("Calling: " + service + ".findByIndex();");
		musicService.findByIndex(1);
		musicService.findByIndex(1);
		musicService.findByIndex(0);
		musicService.findByIndex(0);

		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.println("Calling: " + service + ".save();");
		musicService.save("Balalaika");

		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.println("Calling: " + service + ".findAll();");
		System.out.println("Occurrences: " + musicService.findAll());
		System.out.println("Occurrences: " + musicService.findAll());

		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.println("Calling: " + service + ".delete();");
		musicService.delete("Bass");

		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.println("Calling: " + service + ".findAll();");
		System.out.println("Occurrences: " + musicService.findAll());
		System.out.println("Occurrences: " + musicService.findAll());

		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.println("Calling: " + service + ".deleteAll();");
		musicService.deleteAll();

		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.println("Calling: " + service + ".findAll();");
		System.out.println("Occurrences: " + musicService.findAll());
		System.out.println("Occurrences: " + musicService.findAll());

		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.println("Calling: " + service + ".play();");
		musicService.play("trombone");
		musicService.play("trombone");
		musicService.play("trombone");
		musicService.play("Pan Pipes");
		musicService.play("trombone");
		musicService.play("Pennywhistle");
		musicService.play("trombone");
		musicService.play("Saxophone");
		musicService.play("trombone");
		musicService.play("Sitar");
		musicService.play("Synthesizer");
		musicService.play("trombone");

		context.close();
	}
}
