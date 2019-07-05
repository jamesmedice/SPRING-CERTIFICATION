package com.medici.app.spring.java.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.medici.app.spring.prototype.PrototypeBean;
import com.medici.app.spring.prototype.SingletonBean;

@Configuration
public class AppConfigBean {

	@Bean
	public SingletonBean singletonBean() {
		return new SingletonBean();
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.INTERFACES)
	public PrototypeBean prototypeBean() {
		return new PrototypeBean();
	}

}
