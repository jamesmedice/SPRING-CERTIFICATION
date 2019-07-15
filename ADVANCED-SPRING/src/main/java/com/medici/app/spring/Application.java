package com.medici.app.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.processor.SingletonBean;

public class Application {

	public Application() {
		super();
	}

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.registerShutdownHook();

		SingletonBean bean = context.getBean(SingletonBean.class);
		bean.showMessage();

		context.close();
	}
}
