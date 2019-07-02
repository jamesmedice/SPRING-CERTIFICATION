package com.medici.app.spring.java.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.medici.app.spring.java.dao.BaseDAO;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class ApplicationBeansConfig {

	@Autowired
	Environment env;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String jdbcURL;

	/* Define PropertySourcesPlaceholderConfigure spring bean. */
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcePlaceholderConfig() {
		PropertySourcesPlaceholderConfigurer ret = new PropertySourcesPlaceholderConfigurer();
		return ret;
	}

	/* Define datasource object spring bean. */
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(jdbcURL);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean(name = "baseDao")
	public BaseDAO getUserAccountDao(DataSource dataSource) {
		return new BaseDAO(dataSource);
	}

}