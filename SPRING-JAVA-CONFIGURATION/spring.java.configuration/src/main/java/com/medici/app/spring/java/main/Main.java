package com.medici.app.spring.java.main;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.medici.app.spring.java.configuration.ApplicationBeansConfig;
import com.medici.app.spring.java.dao.BaseDAO;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationBeansConfig.class);
		context.refresh();

		BaseDAO baseDao = (BaseDAO) context.getBean("baseDao");

		baseDao.getDatabaseMetaData();

		ConfigurableListableBeanFactory factory = context.getBeanFactory();
		for (String name : factory.getBeanDefinitionNames()) {
			BeanDefinition bd = factory.getBeanDefinition(name);

			if (bd.getSource() instanceof AnnotatedTypeMetadata) {
				AnnotatedTypeMetadata metadata = (AnnotatedTypeMetadata) bd.getSource();

				System.out.println(metadata.toString());

			}
		}

	}
}
