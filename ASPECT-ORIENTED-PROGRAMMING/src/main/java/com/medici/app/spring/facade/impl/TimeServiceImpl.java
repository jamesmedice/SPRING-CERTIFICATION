package com.medici.app.spring.facade.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.medici.app.spring.facade.TimeService;

@Service("timeService")
public class TimeServiceImpl implements TimeService {

	public LocalDate getNextAssessmentDate() {
		return LocalDate.now();
	}

}
