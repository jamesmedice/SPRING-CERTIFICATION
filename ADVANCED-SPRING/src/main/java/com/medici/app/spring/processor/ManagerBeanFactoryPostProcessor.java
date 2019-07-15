package com.medici.app.spring.processor;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ManagerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public String initValue;

	public void setInitValue(String initValue) {
		this.initValue = initValue;
	}

	public boolean wasCalled = false;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		wasCalled = true;

		for (String beanName : beanFactory.getBeanDefinitionNames()) {

			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

			System.out.println("ManagerBeanFactoryPostProcessor.postProcessBeanFactory: " + beanName);
		}

	}

}
