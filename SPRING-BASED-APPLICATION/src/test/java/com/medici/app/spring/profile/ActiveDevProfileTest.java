package com.medici.app.spring.profile;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.medici.app.spring.config.AppConfigDev;
import com.medici.app.spring.model.User;

@ContextConfiguration(classes = { AppConfigDev.class })
@ActiveProfiles("dev")
public class ActiveDevProfileTest extends ProfileTest {

	@Autowired
	private User user;

	@DisplayName("Single test successful")
	@Test
	public void userTest() throws Exception {

		System.out.println(user.toString());

		assertEquals(200, user.getId().intValue());
		assertEquals("Dev User", user.getName());
	}

}
