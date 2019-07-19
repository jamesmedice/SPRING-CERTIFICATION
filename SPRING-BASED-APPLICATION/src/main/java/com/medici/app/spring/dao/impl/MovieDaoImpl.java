package com.medici.app.spring.dao.impl;

import java.util.Calendar;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.medici.app.spring.dao.MovieDao;
import com.medici.app.spring.model.Movie;

@CacheConfig(cacheNames = { "movie" })
@Repository("movieDao")
public class MovieDaoImpl implements MovieDao {

	@Cacheable
	public Movie findByDirector(String name) {
		slowQuery(2000);
		System.out.println("findByDirector is running..." + Calendar.getInstance().getTime());
		return new Movie(1, "Forrest Gump", "Robert Zemeckis");
	}

	private void slowQuery(long seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
