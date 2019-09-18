package com.medici.app.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.medici.app.spring.model.Advisor;

@Service
public class AdvisorService {

	private List<Advisor> list = new ArrayList<>();

	int counter = 1;

	@PostConstruct
	public void setup() {
		Advisor monitor = new Advisor();
		monitor.setId(counter++);
		monitor.setAge(33);
		monitor.setFirstName("James");
		monitor.setLastName("Medice");
		monitor.setMiddleName("Irons");
		list.add(monitor);

	}

	public List<Advisor> getAllAdvisors() {
		return list;
	}

	public Advisor getAdvisor(int id) throws Exception {
		return list.stream().filter(monitor -> monitor.getId() == id).findFirst().orElseThrow(() -> new Exception("No monitor found"));

	}

	public void addAdvisor(Advisor monitor) {
		monitor.setId(counter++);
		list.add(monitor);

	}

	public void updateAdvisor(@RequestBody Advisor monitor) throws Exception {

		list.stream().filter(u -> u.getId() == monitor.getId()).findFirst().orElseThrow(() -> new Exception("No monitor with monitor id " + monitor.getId()));

		list.removeIf(u -> u.getId() == monitor.getId());
		list.add(monitor);

	}

	public void deleteAdvisor(int id) {
		list.removeIf(u -> u.getId() == id);

	}
}
