package com.medici.app.spring.stand.core.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.medici.app.spring.stereotype.StandAloneAnnotation;

@StandAloneAnnotation
@Component
public class StandBusiness {

	private int nonStaticMember;
	private static int staticMember;

	public void doSomething() {
		System.out.println("Doing something");
		nonStaticMember = 11;
	}

	public void doSomethingElse() {
		System.out.println("Doing something else");
		staticMember = 22;
	}

	public void showTimelineErrors(List<Long> request) {
		System.out.println(request.toString());
	}

}
