package com.medici.app.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.medici.app.spring.model.Monitor;

@Service
public class MonitorService {

	private List<Monitor> list = new ArrayList<>();

	int counter = 1;

	@PostConstruct
	public void setup() {
		Monitor monitor = new Monitor();
		monitor.setId(counter++);
		monitor.setAge(33);
		monitor.setFirstName("James");
		monitor.setLastName("Medice");
		monitor.setMiddleName("Irons");
		list.add(monitor);

	}

	public List<Monitor> getAllMonitors() {
		return list;
	}

	public Monitor getMonitor(int id) throws Exception {
		return list.stream().filter(monitor -> monitor.getId() == id).findFirst().orElseThrow(() -> new Exception("No monitor found"));

	}

	public void addMonitor(Monitor monitor) {
		monitor.setId(counter++);
		list.add(monitor);

	}

	public void updateMonitor(@RequestBody Monitor monitor) throws Exception {

		list.stream().filter(u -> u.getId() == monitor.getId()).findFirst().orElseThrow(() -> new Exception("No monitor with monitor id " + monitor.getId()));

		list.removeIf(u -> u.getId() == monitor.getId());
		list.add(monitor);

	}

	public void deleteMonitor(int id) {
		list.removeIf(u -> u.getId() == id);

	}
}
