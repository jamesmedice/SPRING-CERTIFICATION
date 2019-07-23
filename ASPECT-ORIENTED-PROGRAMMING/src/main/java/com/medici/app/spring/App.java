package com.medici.app.spring;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfig;
import com.medici.app.spring.facade.DirectorService;
import com.medici.app.spring.life.cycle.SmtpService;
import com.medici.app.spring.model.Director;
import com.medici.app.spring.stand.core.impl.CoreBusiness;
import com.medici.app.spring.stand.core.impl.CoreStubBusiness;
import com.medici.app.spring.stand.core.impl.StandBusiness;

/**
 * 
 * @author a73s
 *
 */
public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		try {
			SmtpService mailService1 = context.getBean(SmtpService.class);
			System.out.println(mailService1.getProperties().toString());
			System.out.println(mailService1.getTree().toString());
			mailService1.send("medice@dust.com");
			mailService1.throwIllegalArgument("[exception]");
		} catch (Exception e) {
		}

		DirectorService service = (DirectorService) context.getBean("directorService");
		Director director = new Director();
		director.setName("James Medici");
		service.registerDirector(director);
		director.setName(" Medici hoffeinhein");
		service.mergeDirector(director);
		service.findDirectorById(10);
		service.findAll();

		CoreBusiness core = context.getBean(CoreBusiness.class);
		core.diposite("1144 31305 1", 5000L);
		core.checkBalance("1144 31305 1");
		core.transfer("1144 31305 1", "4411 53031 9", 60000L);
		core.withdrawal("1144 31305 1", 100L);
		core.showTimes();

		CoreStubBusiness single = context.getBean(CoreStubBusiness.class);
		single.sysAspectAnnotation("1144 31305 1");
		single.showMapping();

		StandBusiness business = context.getBean(StandBusiness.class);
		business.doSomething();
		business.doSomethingElse();
		business.showTimelineErrors(Arrays.asList(Calendar.getInstance().getTimeInMillis(), Calendar.getInstance().getTimeInMillis(), Calendar.getInstance().getTimeInMillis(), Calendar.getInstance().getTimeInMillis()));

		context.close();
	}
}
