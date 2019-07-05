package com.medici.app.spring.prototype;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonBean {

	@Autowired
	private IPrototype prototypeBean;

	public void showMessage() {
		System.out.println(prototypeBean.getDateTime());
	}
}
