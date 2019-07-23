package com.medici.app.spring.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.medici.app.spring.dao.DirectorDao;
import com.medici.app.spring.model.Director;

@Repository
public class DirectorDaoImpl implements DirectorDao {

	public void saveInDatabase(Director director) {

		System.out.println("Director " + director.getName() + " is registered for assessment on " + director.getAssessmentDate());

	}

	public void updateDirector(Director director) {

		throw new NullPointerException("ID not found");

	}

	public Director findDirectorById(int directorId) {
		return getDirector();
	}

	public List<Director> findAll() {
		Director director = getDirector();
		return Arrays.asList(director);
	}

	private Director getDirector() {
		Director director = new Director();
		director.setId(15);
		director.setName("James Dean");
		return director;
	}

}
