package com.medici.app.spring;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.model.Actor;
import com.medici.app.spring.model.Customer;
import com.medici.app.spring.service.ActorService;
import com.medici.app.spring.service.CustomerService;

public class App {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		customerProc(context);

		ActorService service = context.getBean(ActorService.class);

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("//////////////////////////////////////////@@CachePut///////////////////////////////////////");
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("service.findById(200)");
		Actor actorId = service.findById(200);
		System.out.println(actorId.toString());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("service.findById(200)");
		actorId = service.findById(200);
		System.out.println(actorId.toString());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("service ");
		actorId.setLast_update(Calendar.getInstance().getTime());
		service.update(actorId);

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("service.findById(200)");
		actorId = service.findById(200);
		System.out.println(actorId.toString());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("//////////////////////////////////////////@@CacheEvict///////////////////////////////////////");
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		List<Actor> payload = service.findByLimit(10, 195);

		for (Actor target : payload)
			System.out.println(target.toString());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		payload = service.findByLimit(10, 195);

		for (Actor target : payload)
			System.out.println(target.toString());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("service.insert(actorId)");
		service.insert(actorId);

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		payload = service.findByLimit(10, 195);

		for (Actor target : payload)
			System.out.println(target.toString());

		context.close();
	}

	private static void customerProc(AbstractApplicationContext context) {
		CustomerService service = context.getBean(CustomerService.class);

		List<Customer> customers = new ArrayList<>();
		Customer customer = null;

		int index = 0;

		for (Customer target : service.getAll()) {
			System.out.println(target.toString());

			if (index % 15000 == 0) {
				customer = new Customer();
				BeanUtils.copyProperties(target, customer);
				customers.add(customer);
			}

			index++;
		}

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("Max Rows: " + index);

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("INSERT Rows: " + customers.size());
		service.insertBatch1(customers);

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("Max Rows: " + index + customers.size());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("Last Customer: " + customer.toString());

		customer.setLast_update(Calendar.getInstance().getTime());
		service.update(customer);

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("Update Last Customer: " + customer.toString());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("call findByEmail");
		List<Customer> mails = service.findByEmail("CAROLYN.PEREZ@sakilacustomer.org");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("call findByEmail");
		mails = service.findByEmail("CAROLYN.PEREZ@sakilacustomer.org");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("call findByFullName");
		mails = service.findByFullName("RA", "O");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("call findByFullName");
		mails = service.findByFullName("RA", "O");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("call findByFullName");
		mails = service.findByFullName("DRA", "MAR");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("call findByFullName");
		mails = service.findByFullName("DRA", "MAR");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("call findByFullName");
		mails = service.findByFullName("DRA", "ART");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("call findByFullName");
		mails = service.findByFullName("NDRA", "ART");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("call findByFullName");
		mails = service.findByFullName("NDRA", "ARTIN");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("call findByFullName");
		mails = service.findByFullName("SANDRA", "TIN");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("call findByFullName");
		mails = service.findByFullName("SANDRA", "TIN");
		System.out.println("Cacheable List: " + mails.size());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("call findById");
		Customer entity = service.findById(20634);
		System.out.println(entity.toString());

		System.out.println("call findById");
		entity = service.findById(20634);
		System.out.println(entity.toString());

		entity = new Customer();
		entity.setCustomer_id(5);

		System.out.println("call findById entity");
		entity = service.findById(entity);
		System.out.println(entity.toString());

		System.out.println("call findById entity");
		entity = service.findById(entity);
		System.out.println(entity.toString());

		entity.setCustomer_id(15);

		System.out.println("call findById entity");
		entity = service.findById(entity);
		System.out.println(entity.toString());

		System.out.println("call findById entity");
		entity = service.findById(entity);
		System.out.println(entity.toString());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("call findById");
		entity = service.findById(20635);
		System.out.println(entity.toString());

		System.out.println("update");
		entity.setEmail("MARY.SMITH@sakilacustomer.org");
		service.update(entity);

		System.out.println("call findById");
		entity = null;
		entity = service.findById(20635);
		System.out.println(entity.toString());

		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("call findByLimit");
		List<Customer> entities = service.findByLimit(10, 2);

		for (Customer ent : entities) {
			System.out.println(ent.toString());

			customer = new Customer();
			BeanUtils.copyProperties(ent, customer);
			customers.add(customer);

			break;
		}

		System.out.println("call findById");
		Customer updatedCustomer = service.findById(customer);
		System.out.println(updatedCustomer.toString());

		System.out.println("call update");
		updatedCustomer.setEmail("LINDA.WILLIAMS@sakilacustomer.org");
		service.update(updatedCustomer);

		System.out.println("call findById");
		updatedCustomer = service.findById(customer);
		System.out.println(updatedCustomer.toString());
	}

}
