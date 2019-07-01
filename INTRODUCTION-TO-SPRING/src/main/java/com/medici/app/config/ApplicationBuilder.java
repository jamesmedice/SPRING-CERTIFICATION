package com.medici.app.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("applicationBuilder")
public class ApplicationBuilder {

	@Autowired
	private ApplicationContext appContext;

	public void run(String... args) {
		String[] beans = appContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		for (String bean : beans) {
			System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
		}
	}
}
