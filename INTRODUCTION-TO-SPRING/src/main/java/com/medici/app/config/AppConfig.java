package com.medici.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.medici.app.event.CustomEventHandler;
import com.medici.app.event.CustomEventPublisher;
import com.medici.app.handler.ContextStartEventHandler;
import com.medici.app.handler.ContextStopEventHandler;
import com.medici.app.service.Manager;
import com.medici.app.service.ManagerImpl;

@Import({ SchedulerConfig.class, ApplicationBuilder.class })
@Configuration
public class AppConfig {

	@Bean(name = "managerService")
	public Manager getServiceName() {
		return new ManagerImpl();
	}

	@Bean(name = "contextStartEventHandler")
	public ContextStartEventHandler getContextStartEventHandler() {
		return new ContextStartEventHandler();
	}

	@Bean(name = "contextStopEventHandler")
	public ContextStopEventHandler getContextStopEventHandler() {
		return new ContextStopEventHandler();
	}

	@Bean(name = "customEventPublisher")
	public CustomEventPublisher getCustomEventPublisher() {
		return new CustomEventPublisher();
	}

	@Bean(name = "customEventHandler")
	public CustomEventHandler getCustomEventHandler() {
		return new CustomEventHandler();
	}

}