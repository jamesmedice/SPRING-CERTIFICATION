package com.medici.app.spring.dao;

import java.util.List;

import com.medici.app.spring.model.Director;

public interface DirectorDao {

	void saveInDatabase(Director director);

	void updateDirector(Director director);

	Director findDirectorById(int directorId);

	List<Director> findAll();
}
