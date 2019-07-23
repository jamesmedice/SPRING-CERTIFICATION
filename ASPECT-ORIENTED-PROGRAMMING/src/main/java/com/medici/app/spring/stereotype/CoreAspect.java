package com.medici.app.spring.stereotype;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CoreAspect {

	@Pointcut("within(com.medici.app.spring.stand.core.CoreTransferMarket+)")
	public void coreMethods() {
	};

	@Before("coreMethods()")
	public void beforeCoreMethods(JoinPoint joinPoint) {
		System.out.println("CoreAspect.beforeCoreMethods() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "execution (Long com.medici.app.spring.stand.*.*.*.with*(String , Long))", returning = "payload")
	public void afterReturningPayloadLong(JoinPoint joinPoint, Object payload) {
		System.out.println("CoreAspect.afterReturningCoreMethods() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		System.out.println("CoreAspect.afterReturningCoreMethods().payload() : " + payload.toString());
	}

	@AfterReturning(pointcut = "execution (Double com.medici.app.spring.stand.*.*.*.*ckB*(String))", returning = "payload")
	public void afterReturningPayloadDouble(JoinPoint joinPoint, Object payload) {
		System.out.println("CoreAspect.afterReturningCoreMethods() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		System.out.println("CoreAspect.afterReturningCoreMethods().payload() : " + payload.toString());
	}

	@AfterReturning(pointcut = "execution (public java.util.Collection com.medici.app.spring.stand.*.*.Core*.show*(..))", returning = "payload")
	public void afterReturningPayloadCollection(JoinPoint joinPoint, Object payload) {
		System.out.println("CoreAspect.afterReturningPayloadCollection() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		System.out.println("CoreAspect.afterReturningPayloadCollection().payload() : " + payload.toString());
	}

	@After("execution (java.util.Collection com.medici.app.spring.stand.*.*.Core*.*(..))")
	public void afterPayloadCollection(JoinPoint joinPoint) {
		System.out.println("CoreAspect.afterPayloadCollection() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

}
