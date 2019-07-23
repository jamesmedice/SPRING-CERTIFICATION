package com.medici.app.spring.profile;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.medici.app.spring.config.AppConfigQA;
import com.medici.app.spring.model.User;

@ContextConfiguration(classes = { AppConfigQA.class })
@ActiveProfiles("qa")
public class ActiveQAProfileTest extends ProfileTest {

	@Autowired
	private User user;

	@Autowired
	Environment env;

	@Value("${spring.profiles.active}")
	private String activeProfile;

	@Value("${run.integration.tests}")
	private String runner;

	@Repeat(2)
	@Test
	public void showActiveProfile() {
		System.out.println(Calendar.getInstance().getTime().getTime());
		System.out.println(activeProfile);
		System.out.println(env.getProperty(SPRING_PROFILES_ACTIVE));
	}

	@Repeat(5)
	@Timed(millis = 2222)
	@Test
	public void showPeriod() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		Thread.sleep(150);
		long endTime = System.currentTimeMillis();
		System.out.println("timing: " + (endTime - startTime));
	}

	@IfProfileValue(name = "run.integration.tests", value = "true")
	@Test
	public void showRunnerIntegration() {
		System.out.println(runner);
	}

	@Test
	public void userTest() throws Exception {
		System.out.println(user.toString());
		assertEquals(100, user.getId().intValue());
		assertEquals("QA User", user.getName());
	}

}
