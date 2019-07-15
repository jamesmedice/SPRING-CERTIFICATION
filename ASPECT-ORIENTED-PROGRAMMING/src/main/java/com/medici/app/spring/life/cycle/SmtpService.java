package com.medici.app.spring.life.cycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class SmtpService {

	private Map<String, String> map = null;

	public SmtpService() {
		map = new HashMap<String, String>();
	}

	public void send(String mailTo) {
		System.out.println("Inside send method - " + mailTo);
	}

	public Collection<String> getProperties() {
		if (map == null)
			map = new HashMap<String, String>();

		return map.values();
	}

	@PostConstruct
	public void init() {
		map.put("host", "mail.example.com");
		map.put("port", "25");
		map.put("from", "james@medici.com");
		System.out.println("Inside init method - " + map);
	}

	@PreDestroy
	public void destroy() {
		map.clear();
		System.out.println("Inside destroy method - " + map);
	}
}
