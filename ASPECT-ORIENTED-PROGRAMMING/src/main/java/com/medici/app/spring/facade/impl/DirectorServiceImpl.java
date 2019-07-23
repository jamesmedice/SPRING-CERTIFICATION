package com.medici.app.spring.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medici.app.spring.dao.DirectorDao;
import com.medici.app.spring.facade.DirectorService;
import com.medici.app.spring.facade.TimeService;
import com.medici.app.spring.model.Director;

@Service("directorService")
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	TimeService timeService;

	@Autowired
	DirectorDao directorDao;

	public void registerDirector(Director director) {
		director.setAssessmentDate(timeService.getNextAssessmentDate());
		directorDao.saveInDatabase(director);
	}

	public void mergeDirector(Director director) {
		try {
			director.setAssessmentDate(timeService.getNextAssessmentDate());
			directorDao.updateDirector(director);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Director findDirectorById(int directorId) {
		return directorDao.findDirectorById(directorId);
	}

	public List<Director> findAll() {
		return directorDao.findAll();
	}
}
