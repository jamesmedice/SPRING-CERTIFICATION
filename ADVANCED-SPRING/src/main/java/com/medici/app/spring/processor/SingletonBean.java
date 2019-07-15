package com.medici.app.spring.processor;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.app.spring.model.PrototypeBean;

public class SingletonBean {

	public SingletonBean() {
		System.out.println("New Instance [SingletonBean]");
	}

	@Autowired
	private PrototypeBean prototypeBean;

	public void showMessage() {
		System.out.println("timer: " + prototypeBean.getDateTime());
	}
}
