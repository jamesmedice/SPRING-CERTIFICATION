package com.medici.app.spring;

import java.util.Calendar;

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
}
