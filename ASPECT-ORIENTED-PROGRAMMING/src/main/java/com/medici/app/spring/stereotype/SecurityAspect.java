package com.medici.app.spring.stereotype;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect implements Ordered {

	@Before("execution(java.util.List *.*All(..))")
	public void beforeAdviceTransferMethods(JoinPoint jp) throws Throwable {
		System.out.println("SecurityAspect.beforeAdviceTransferMethods() " + jp.getSignature().getName());
	}

	public int getOrder() {
		return 0;
	}
}
