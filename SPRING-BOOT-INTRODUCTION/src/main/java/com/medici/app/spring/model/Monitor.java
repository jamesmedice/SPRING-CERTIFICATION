package com.medici.app.spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Class representing Monitor ")
public class Monitor {

	@ApiModelProperty(notes = "Unique  ID for user", example = "1", required = true, position = 0)
	private int id;

	@ApiModelProperty(notes = "First Name of Monitor", example = "James", required = true, position = 1)
	private String firstName;

	@ApiModelProperty(notes = "Last Name of Monitor", example = "Medice", required = true, position = 2)
	private String lastName;

	@ApiModelProperty(notes = "Middle Name of Monitor", example = "Irons", required = false, position = 3)
	private String middleName;

	@ApiModelProperty(notes = "Age of Monitor", example = "32", required = true, position = 4)
	private Integer age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}