package com.medici.app.event;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

	private static final String EVENT = "event";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomEvent(Object source) {
		super(source);
	}

	public String getEvent() {
		return EVENT;
	}

}
