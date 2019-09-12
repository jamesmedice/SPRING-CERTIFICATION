package com.medici.app.spring.resource;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "dev")
@Component
public class InMemoryDataSource implements AppDataSource {

	public String getDataSourceName() {
		return "inMemoryDataSource";
	}
}
