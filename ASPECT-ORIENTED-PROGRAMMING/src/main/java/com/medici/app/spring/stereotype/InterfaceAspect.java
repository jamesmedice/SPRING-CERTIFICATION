package com.medici.app.spring.stereotype;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InterfaceAspect {

	@Pointcut("target(com.medici.app.spring.stand.core.CoreSingleMarket)")
	public void methodCoreSingleMarket() {
	};

	@Around("methodCoreSingleMarket()")
	public void aroundCoreSingleMarket(JoinPoint joinPoint) {
		System.out.println("InterfaceAspect.aroundCoreSingleMarket() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

}
