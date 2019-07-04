package com.medici.app.spring.resource;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "qa")
@Component
public class QADataSource implements AppDataSource {
	
	public String getDataSourceName() {
		return "qaDataSource";
	}
}