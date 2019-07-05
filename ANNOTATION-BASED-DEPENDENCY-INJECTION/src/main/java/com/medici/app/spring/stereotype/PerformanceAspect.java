package com.medici.app.spring.stereotype;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

	@Before("execution(* com.medici.app.spring.*.*.*.send*(..))")
	public void logBeforeSendMethods(JoinPoint joinPoint) {
		System.out.println("SEND METHOD - LoggingAspect.logBeforeSendMethods() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.medici.app.spring.*.*.*.send*(..))")
	public void logAfterSendMethods(JoinPoint joinPoint) {
		System.out.println("SEND METHOD - LoggingAspect.logAfterAllMethods() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.medici.app.spring.*.*.*.*Properties*(..))")
	public void logAfterPropertiesMethods(JoinPoint joinPoint) {
		System.out.println("PROPERTIES METHOD - LoggingAspect.logAfterPropertiesMethods() : " + joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* com.medici.app.spring.*.*.*.*Properties*(..))")
	public void logAfterReturningPropertiesMethods(JoinPoint joinPoint) {
		System.out.println("PROPERTIES METHOD - LoggingAspect.logAfterReturningPropertiesMethods() : " + joinPoint.getSignature().getName());
	}

	@AfterThrowing(pointcut = "execution(* com.medici.app.spring.*.*.*.update*(..))", throwing = "ex")
	public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
		System.out.println("****LoggingAspect.logAfterThrowingAllMethods() " + ex);
	}

	@Pointcut("execution(* com.medici.app.spring.*.*.*.send*(..))")
	public void send() {
	};

	@Around("send()")
	public Object sendMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		Object returnValue = joinPoint.proceed();
		long end = System.nanoTime();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("SEND METHOD: Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
		return returnValue;
	}

	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void repositoryClassMethods() {
	};

	@Around("repositoryClassMethods()")
	public Object repositoryMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		Object returnValue = joinPoint.proceed();
		long end = System.nanoTime();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Repository 	Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
		return returnValue;
	}

	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void serviceClassMethods() {
	};

	@Around("serviceClassMethods()")
	public Object serviceMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		Object returnValue = joinPoint.proceed();
		long end = System.nanoTime();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Service Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
		return returnValue;
	}
}
