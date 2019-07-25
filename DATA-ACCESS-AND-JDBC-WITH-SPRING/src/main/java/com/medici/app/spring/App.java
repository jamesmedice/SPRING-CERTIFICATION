package com.medici.app.spring;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.model.Customer;
import com.medici.app.spring.service.CustomerService;

public class App {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		CustomerService service = context.getBean(CustomerService.class);

		List<Customer> customers = new ArrayList<>();
		Customer customer = null;

		int index = 0;

		for (Customer target : service.getAll()) {
			System.out.println(target.toString());

			customer = new Customer();
			BeanUtils.copyProperties(target, customer);
			customers.add(customer);

			index++;
		}

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("Max Rows: " + index);

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		service.insertBatch1(customers);

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		index = 0;
		for (Customer target : service.findAll()) {
			System.out.println(target.toString());
			index++;
		}

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("Max Rows: " + index);

		
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("Last Customer: " + customer.toString());

		customer.setLast_update(Calendar.getInstance().getTime());
		service.update(customer);
		

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("Update Last Customer: " + customer.toString());

		context.close();
	}

}
