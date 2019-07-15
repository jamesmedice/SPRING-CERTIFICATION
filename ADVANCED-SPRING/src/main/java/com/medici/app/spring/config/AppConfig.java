package com.medici.app.spring.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.medici.app.spring.model.Employee;
import com.medici.app.spring.model.Manager;
import com.medici.app.spring.model.PrototypeBean;
import com.medici.app.spring.processor.ManagerBeanFactoryPostProcessor;
import com.medici.app.spring.processor.ManagerBeanPostProcessor;
import com.medici.app.spring.processor.SingletonBean;
import com.medici.app.spring.service.AwareService;
import com.medici.app.spring.service.EmployeeService;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.medici.app.spring")
public class AppConfig {

	@Bean("managerBean")
	public ManagerBeanPostProcessor getManagerBean() {
		ManagerBeanPostProcessor bean = new ManagerBeanPostProcessor();
		return bean;
	}

	@Bean("managerBeanFactory")
	public ManagerBeanFactoryPostProcessor getManagerBeanFactory() {
		ManagerBeanFactoryPostProcessor bean = new ManagerBeanFactoryPostProcessor();
		return bean;
	}

	@Bean(name = "manager", initMethod = "mainPostConstruct", destroyMethod = "mainPreDestroy")
	public Manager getManager() {
		Manager bean = new Manager();
		bean.setCompany("companyBean");
		return bean;
	}

	@Bean(name = "employee")
	public Employee getEmployee() {
		Employee bean = new Employee();
		return bean;
	}

	@Bean(name = "service")
	public EmployeeService getEmployeeService() {
		EmployeeService service = new EmployeeService();
		service.setEmployee(new Employee());
		return service;
	}

	@Bean(name = "awareService")
	public AwareService getAwareService() {
		AwareService service = new AwareService();
		return service;
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public PrototypeBean prototypeBean() {
		return new PrototypeBean();
	}

	@Bean
	public SingletonBean singletonBean() {
		return new SingletonBean();
	}
}
