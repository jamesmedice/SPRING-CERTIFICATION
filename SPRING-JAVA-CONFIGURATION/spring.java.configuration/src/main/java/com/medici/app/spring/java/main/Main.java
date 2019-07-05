package com.medici.app.spring.java.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.medici.app.spring.java.configuration.AppConfig;
import com.medici.app.spring.java.configuration.AppConfigBean;
import com.medici.app.spring.java.configuration.ApplicationDBConfig;
import com.medici.app.spring.java.dao.BaseDAO;
import com.medici.app.spring.java.model.SuperUser;
import com.medici.app.spring.java.spel.AccessCollections;
import com.medici.app.spring.java.spel.ArithmeticOperators;
import com.medici.app.spring.java.spel.LogicalOperators;
import com.medici.app.spring.java.spel.RegexOperations;
import com.medici.app.spring.prototype.SingletonBean;
import com.medici.app.spring.resource.AppDataSource;

public class Main {

	public static void main(String[] args) {

		System.setProperty("db.password", "APPLICATION");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationDBConfig.class);
		context.getEnvironment().setActiveProfiles("dev");
		context.register(AppConfig.class);
		context.register(AppConfigBean.class);
		context.refresh();

		AppDataSource bean = context.getBean(AppDataSource.class);
		System.out.println(bean.getDataSourceName());
		System.out.println("/////////////////////////////////////////////////////////////////////");

		SingletonBean singletonBean = context.getBean(SingletonBean.class);
		singletonBean.showMessage();
		System.out.println("/////////////////////////////////////////////////////////////////////");

		BaseDAO baseDao = (BaseDAO) context.getBean("baseDao");
		System.out.println(baseDao.getDatabaseMetaData());
		System.out.println("/////////////////////////////////////////////////////////////////////");

		AccessCollections collections = context.getBean(AccessCollections.class);
		System.out.println(collections.getFirstWorker());
		System.out.println(collections.getLastWorker());
		System.out.println(collections.getGeorgeSalary());
		System.out.println(collections.getJohnSalary());
		System.out.println(collections.getNumberOfWorkers());
		System.out.println(collections.getSusieSalary());
		System.out.println("/////////////////////////////////////////////////////////////////////");

		ArithmeticOperators arithmetic = context.getBean(ArithmeticOperators.class);
		System.out.println(arithmetic.getAddString());
		System.out.println(arithmetic.getBrackets());
		System.out.println(arithmetic.getDivideAlphabetic());
		System.out.println(arithmetic.getModuloAlphabetic());
		System.out.println(arithmetic.getModulo());
		System.out.println(arithmetic.getPowerOf());
		System.out.println("/////////////////////////////////////////////////////////////////////");

		LogicalOperators logical = context.getBean(LogicalOperators.class);
		System.out.println(logical.isAnd());
		System.out.println(logical.isAndAlphabetic());
		System.out.println(logical.isNot());
		System.out.println(logical.isNotAlphabetic());
		System.out.println(logical.isOr());
		System.out.println(logical.isOrAlphabetic());
		System.out.println("/////////////////////////////////////////////////////////////////////");

		RegexOperations regex = context.getBean(RegexOperations.class);
		System.out.println(regex.isValidNumericValue());
		System.out.println("/////////////////////////////////////////////////////////////////////");

		SuperUser superUser = context.getBean(SuperUser.class);
		System.out.println(superUser.getUsername());
		System.out.println("/////////////////////////////////////////////////////////////////////");

		Environment environment = context.getBean(Environment.class);
		System.out.println(environment.getProperty("user.home"));
		System.out.println(environment.getProperty("cassandra.server"));
		System.out.println(environment.getProperty("db.password.2"));
		System.out.println("/////////////////////////////////////////////////////////////////////");

		SuperUser suser = new SuperUser("advisor", 100002);
		StandardEvaluationContext superContext = new StandardEvaluationContext(suser);

		ExpressionParser parser = new SpelExpressionParser();
		Expression label = parser.parseExpression("username");
		Expression value = parser.parseExpression("time");

		System.out.println(label.getValue(superContext, String.class));
		System.out.println(value.getValue(superContext, Long.class));

		context.close();

	}
}
