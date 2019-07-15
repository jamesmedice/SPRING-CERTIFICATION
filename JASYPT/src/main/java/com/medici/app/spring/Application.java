package com.medici.app.spring;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.medici.app.spring.config.AppConfiguration;
import com.medici.app.spring.model.Employee;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public Application() {
		super();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) throws Exception {
		String password = "secret";
		String algorithm = "SHA";

		MessageDigest md = MessageDigest.getInstance(algorithm);
		byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

		// bytes to hex
		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
		}
		System.out.println(sb.toString());

		md = MessageDigest.getInstance(algorithm);
		md.update(sb.toString().getBytes(StandardCharsets.UTF_8));
		char[] raw = md.digest().toString().toCharArray();
		System.out.println(new String(Hex.decodeHex(raw)));

		SpringApplication.run(Application.class, args);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

		Employee manager = (Employee) context.getBean("manager");
		System.out.println(manager.toString());

		System.out.println(System.getenv().values().toString());

		context.close();
	}
}
