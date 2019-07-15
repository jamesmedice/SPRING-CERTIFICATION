package com.medici.app.spring.model;

import java.time.LocalDateTime;

public class PrototypeBean {

	public PrototypeBean() {
		System.out.println("New Instance [PrototypeBean]");
	}

	private String dateTimeString = LocalDateTime.now().toString();

	public String getDateTime() {
		return dateTimeString;
	}
}
