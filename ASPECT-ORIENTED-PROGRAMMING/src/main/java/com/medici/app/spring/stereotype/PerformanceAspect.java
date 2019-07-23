package com.medici.app.spring.stereotype;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void serviceClassMethods() {
	};

	@Around("serviceClassMethods()")
	public Object serviceMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		Object returnValue = joinPoint.proceed();
		long end = System.nanoTime();
		String clazzName = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("PerformanceAspect.serviceMethodExecutionTime: Excecution of " + clazzName + " method: " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
		return returnValue;
	}
}
