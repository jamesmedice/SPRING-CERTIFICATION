package com.medici.app.spring.java.model;

public class SuperUser {

	public SuperUser(String username) {
		super();
		this.username = username;
	}

	public SuperUser(String username, long time) {
		this.username = username;
		this.time = time;
	}

	private String username;

	private Long time;

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
