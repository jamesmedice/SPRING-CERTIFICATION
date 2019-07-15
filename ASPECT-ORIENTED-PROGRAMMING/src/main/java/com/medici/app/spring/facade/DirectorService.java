package com.medici.app.spring.facade;

import java.util.List;

import com.medici.app.spring.model.Director;

public interface DirectorService {

	void registerDirector(Director director);

	void mergeDirector(Director director);

	Director findDirector(int directorId);

	List<Director> allDirectors();
}
