package com.medici.app.spring.stereotype;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class LoggingAspect {

	@Before("execution(* com.medici.app.spring.*.*.*.send*(..))")
	public void logBeforeSendMethods(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logBeforeSendMethods() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	@After("execution(* com.medici.app.spring.*.*.*.send*(..))")
	public void logAfterSendMethods(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAfterSendMethods() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	@After("execution(* com.medici.app.spring.*.*.*.*Properties*(..))")
	public void logAfterPropertiesMethods(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAfterPropertiesMethods() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "execution(* com.medici.app.spring.*.*.*.*Properties*(..))", returning = "payload")
	public void logAfterReturningPropertiesMethods(JoinPoint joinPoint, Object payload) {
		System.out.println("LoggingAspect.logAfterReturningPropertiesMethods() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	@AfterThrowing(pointcut = "execution(* com.medici.app.spring.*.*.*.throw*(..))", throwing = "ex")
	public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
		System.out.println("LoggingAspect.logAfterThrowingAllMethods() " + ex);
	}

}
