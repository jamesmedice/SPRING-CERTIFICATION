package com.medici.app.spring.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.medici.app.spring.utils.CypherUtils;

@Configuration
@PropertySource("classpath:application-test.properties")
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfigTest {

	@Value("${mysql.driverClassName}")
	private String driver;

	@Value("${mysql.url}")
	private String url;

	@Value("${mysql.username}")
	private String username;

	@Value("${mysql.password}")
	private String pass;

	@Value("${standAloneKeyCode}")
	private String standAloneKeyCode;

	@Value("${saltGate}")
	private String saltGate;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(CypherUtils.decrypt(pass, standAloneKeyCode, saltGate));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() throws IOException {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.medici.app.spring.model");
		return factoryBean;
	}

	@Bean
	public PlatformTransactionManager getTransactionManager() throws IOException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
