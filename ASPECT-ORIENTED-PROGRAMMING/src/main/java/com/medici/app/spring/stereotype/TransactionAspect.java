package com.medici.app.spring.stereotype;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

	@Pointcut("execution(* com.medici.app.spring.dao.*.*.*All(..))")
	private void findMethods() {
	}

	@Around("findMethods()")
	public void logAround(JoinPoint joinPoint) {
		System.out.println("TransactionAspect.logAround() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	@After("findMethods()")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("TransactionAspect.logAfter() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

}
