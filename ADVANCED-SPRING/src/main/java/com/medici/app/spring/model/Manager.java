package com.medici.app.spring.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class Manager implements InitializingBean, DisposableBean, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware {

	private String company;
	
	@Value("${md.db.password}")
	private String password;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

		System.out.println("setPassword: company has set." + this.password);
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;

		System.out.println("setCompany: company has set.");
	}

	public void mainPostConstruct() {
		System.out.println("---init-method---");
	}

	public void mainPreDestroy() {
		System.out.println("---destroy-method---");
	}
	
	@PostConstruct
	public void springPostConstruct() {
		System.out.println("---@PostConstruct---");
	}

	@PreDestroy
	public void springPreDestroy() {
		System.out.println("---@PreDestroy---");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("---setBeanClassLoader---");

	}

	@Override
	public void setBeanName(String name) {
		System.out.println("---setBeanName---");

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("---setBeanFactory---");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("---destroy---");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("---afterPropertiesSet---");

	}

	@Override
	protected void finalize() {
		System.out.println("---inside finalize---");
	}
}
