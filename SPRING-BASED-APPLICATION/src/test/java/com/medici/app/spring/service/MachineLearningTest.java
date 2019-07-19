package com.medici.app.spring.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.service.impl.MachineLearningService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MachineLearningTest {

	@Autowired
	@Qualifier("machine")
	DataModelService machine;

	@Test
	public void test_machine_learning_return_true() {

		assertThat(machine, instanceOf(MachineLearningService.class));

		assertThat(machine.isValid(""), is(true));

	}

	@Test(expected = StackOverflowError.class)
	public void stackOverflowErrorTest() {
		recursiveLogInfo(1);
	}

	public void recursiveLogInfo(int nummer) {

		if (nummer == 0)
			return;
		else
			recursiveLogInfo(++nummer);
	}

}
