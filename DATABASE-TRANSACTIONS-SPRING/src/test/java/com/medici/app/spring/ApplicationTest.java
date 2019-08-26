package com.medici.app.spring;

import java.util.Calendar;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.medici.app.spring.config.AppConfigTest;
import com.medici.app.spring.model.Actor;
import com.medici.app.spring.service.ActorService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigTest.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApplicationTest {

	@Autowired
	ActorService actorService;

	@Test
	public void test_A() {
		Actor actor = getActor("Bruce", "Irons");
		actorService.insert(actor);
		System.out.println(actor.toString());
	}

	@Test
	public void test_B() {
		Actor actor = actorService.loadById(298);
		System.out.println(actor.toString());
	}

	@Test
	public void test_C() {
		Actor actor = getActor("Bruce", "Slater");
		actor.setActor_id(299);
		actorService.update(actor);
		System.out.println(actor.toString());
	}

	@Test
	public void test_D() {
		Actor actor = actorService.getById(298);
		System.out.println(actor.toString());
	}

	@Test
	public void test_FULL() {
		Actor actor = new Actor();
		actor.setFirst_name("BRUCE");
		actor.setLast_name("IRONS");
		actor.setLast_update(Calendar.getInstance().getTime());
		int actorId = actorService.insert(actor);
		System.out.println(actor.toString());

		actor = actorService.loadById(actorId);
		System.out.println(actor.toString());

		actor.setLast_name("SLATER");
		actorService.update(actor);
		System.out.println(actor.toString());

		actor = actorService.getById(actorId);
		System.out.println(actor.toString());
	}

	private Actor getActor(String name, String lastName) {
		Actor actor = new Actor();
		actor.setFirst_name(name);
		actor.setLast_name(lastName);
		actor.setLast_update(Calendar.getInstance().getTime());
		return actor;
	}
}
