package com.medici.app.spring.service.impl;

import org.springframework.stereotype.Service;

import com.medici.app.spring.service.DataModelService;

@Service("machine")
public class MachineLearningService implements DataModelService {

	@Override
	public boolean isValid(String input) {
		return true;
	}

}
