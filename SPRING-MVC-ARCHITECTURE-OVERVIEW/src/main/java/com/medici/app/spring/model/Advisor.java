package com.medici.app.spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Class representing Advisor ")
public class Advisor {

	@ApiModelProperty(notes = "Unique  ID for user", example = "1", required = true, position = 0)
	private int id;

	@ApiModelProperty(notes = "First Name of Advisor", example = "James", required = true, position = 1)
	private String firstName;

	@ApiModelProperty(notes = "Last Name of Advisor", example = "Medice", required = true, position = 2)
	private String lastName;

	@ApiModelProperty(notes = "Middle Name of Advisor", example = "Irons", required = false, position = 3)
	private String middleName;

	@ApiModelProperty(notes = "Age of Advisor", example = "32", required = true, position = 4)
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}