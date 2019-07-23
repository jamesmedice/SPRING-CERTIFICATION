package com.medici.app.spring.dao;

import com.medici.app.spring.model.Movie;

public interface MovieDao {

	Movie findByDirector(String name);

}