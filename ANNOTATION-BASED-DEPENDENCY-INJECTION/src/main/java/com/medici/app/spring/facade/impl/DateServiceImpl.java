package com.medici.app.spring.facade.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.medici.app.spring.facade.DateService;

@Service("dateService")
public class DateServiceImpl implements DateService {

	public LocalDate getNextAssessmentDate() {
		return LocalDate.now();
	}

}
