package com.medici.app.spring.profile;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.medici.app.spring.config.AppConfigProd;
import com.medici.app.spring.model.User;

@ContextConfiguration(classes = { AppConfigProd.class })
@ActiveProfiles("prod")
public class ActiveProdProfileTest extends ProfileTest {

	@Autowired
	private User user;

	@Test
	public void userTest() throws Exception {
		System.out.println(user.toString());
		assertEquals(100, user.getId().intValue());
		assertEquals("Prod User", user.getName());
	}

}
