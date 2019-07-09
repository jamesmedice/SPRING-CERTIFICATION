package com.medici.app.spring.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class AbstractAutowiringFactoryBean<T> extends AbstractFactoryBean<T> implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	protected T createInstance() throws Exception {
		final T instance = baseCreateInstance();

		if (instance != null)
			applicationContext.getAutowireCapableBeanFactory().autowireBean(instance);

		return instance;
	}

	protected abstract T baseCreateInstance();

}
