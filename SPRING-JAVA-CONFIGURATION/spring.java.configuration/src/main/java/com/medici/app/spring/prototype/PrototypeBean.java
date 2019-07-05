package com.medici.app.spring.prototype;

import java.time.LocalDateTime;

public class PrototypeBean implements IPrototype {

	private String dateTimeString = LocalDateTime.now().toString();

	public String getDateTime() {
		return dateTimeString;
	}

}
