package com.medici.app.spring.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.medici.app.spring.utils.CypherUtils;

@Configuration
@EnableCaching
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfig {

	@Value("${mysql.driverClassName}")
	private String driver;

	@Value("${mysql.url}")
	private String url;

	@Value("${mysql.username}")
	private String username;

	@Value("${mysql.password}")
	private String pass;

	@Value("${standEncrypt}")
	private String keyCode;

	@Value("${salt}")
	private String salt;

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(CypherUtils.decrypt(pass, keyCode, salt));
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		ConcurrentMapCache customerCache = new ConcurrentMapCache("customer");
		ConcurrentMapCache customerLimitCache = new ConcurrentMapCache("customer.limit");
		ConcurrentMapCache customerByIdCache = new ConcurrentMapCache("customer.findById");
		ConcurrentMapCache customerByFullName = new ConcurrentMapCache("customer.findByFullName");
		ConcurrentMapCache customerByEmailCache = new ConcurrentMapCache("customer.findByEmail");

		ConcurrentMapCache actorCache = new ConcurrentMapCache("actor");
		ConcurrentMapCache actorLimitCache = new ConcurrentMapCache("actor.limit");
		ConcurrentMapCache actorByIdCache = new ConcurrentMapCache("actor.findById");

		cacheManager.setCaches(Arrays.asList(actorCache, actorLimitCache, actorByIdCache, customerCache, customerLimitCache, customerByIdCache, customerByEmailCache, customerByFullName));
		return cacheManager;
	}
}
