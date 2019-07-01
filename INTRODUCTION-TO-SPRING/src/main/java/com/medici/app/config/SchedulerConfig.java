package com.medici.app.config;

import org.springframework.context.annotation.Bean;

import com.medici.app.model.SchedulerBo;

public class SchedulerConfig {

	@Bean(name = "scheduler")
	public SchedulerBo suchedulerBo() {
		return new SchedulerBo();
	}

}
