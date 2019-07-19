package com.medici.app.spring.config;

import java.util.Calendar;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextControl {

	@EventListener
	public void handleContextRefreshEvent(ContextRefreshedEvent ctxStartEvt) {
		System.out.println("Context Start Event received @" + Calendar.getInstance().getTime());
	}

}
