package com.medici.app.spring.service;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

public class AwareService implements ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware, BeanNameAware, LoadTimeWeaverAware, MessageSourceAware, NotificationPublisherAware,
		EnvironmentAware, ImportAware, ResourceLoaderAware {

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("AwareService SetApplicationContext called");
		System.out.println("AwareService SetApplicationContext:: Bean Definition Names=" + Arrays.toString(ctx.getBeanDefinitionNames()));
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("AwareService SetBeanName called");
		System.out.println("AwareService SetBeanName:: Bean Name defined in context=" + beanName);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("AwareService SetBeanClassLoader called");
		System.out.println("AwareService SetBeanClassLoader:: ClassLoader Name=" + classLoader.getClass().getName());
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("AwareService SetResourceLoader called");
		Resource resource = resourceLoader.getResource("classpath:application.properties");
		System.out.println("AwareService SetResourceLoader:: Resource File Name=" + resource.getFilename());
	}

	@Override
	public void setImportMetadata(AnnotationMetadata annotationMetadata) {
		System.out.println("AwareService SetImportMetadata called");
	}

	@Override
	public void setEnvironment(Environment env) {
		System.out.println("AwareService SetEnvironment called");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("AwareService SetBeanFactory called");
		System.out.println("AwareService SetBeanFactory:: employee bean singleton=" + beanFactory.isSingleton("employee"));
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("AwareService SetApplicationEventPublisher called");
	}

	@Override
	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
		System.out.println("AwareService setNotificationPublisher called");
		
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("AwareService setMessageSource called");
		
	}

	@Override
	public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
		System.out.println("AwareService setLoadTimeWeaver called");
		
	}

}
