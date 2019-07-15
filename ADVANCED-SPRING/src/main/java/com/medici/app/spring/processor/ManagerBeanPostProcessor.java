package com.medici.app.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ManagerBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("ManagerBeanPostProcessor.postProcessAfterInitialization: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("ManagerBeanPostProcessor.postProcessBeforeInitialization: " + beanName);
		return bean;
	}

}
