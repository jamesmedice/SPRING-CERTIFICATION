package com.medici.app.spring.stereotype;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class TransactionAspect {

	@Before("execution(* com.medici.app.spring.facade.*.*.find*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("TransactionAspect.logBefore() : " + joinPoint.getSignature().getName());
	}

}
