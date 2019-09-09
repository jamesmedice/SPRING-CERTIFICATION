package com.medici.app.spring;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.medici.app.spring.model.Actor;
import com.medici.app.spring.repository.ActorRepository;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@EnableEncryptableProperties
public class JPASpecificationsTest {

	private static Log logger = LogFactory.getLog(JPASpecificationsTest.class);

	@Autowired
	ActorRepository repository;

	@Test
	public void save_Test() {

		Actor entity = new Actor();
		entity.setFirst_name("John");
		entity.setLast_name("Irons");
		entity.setLast_update(Calendar.getInstance().getTime());
		repository.save(entity);
	}

	@Test
	public void findByFirstName_Test() {
		List<Actor> actors = repository.findByFirstName("John");
		logger.info(actors.stream().map(Actor::getLast_name).distinct().collect(Collectors.toList()));
		logger.info(actors.stream().map(actor -> actor.toString()).distinct().collect(Collectors.toList()));
	}

	@Test
	public void findByLastName_Test() {
		List<Actor> actors = repository.findByLastName("Irons");
		logger.info(actors.stream().map(Actor::getFirst_name).distinct().collect(Collectors.toList()));
		logger.info(actors.stream().map(actor -> actor.toString()).distinct().collect(Collectors.toList()));
	}
}
