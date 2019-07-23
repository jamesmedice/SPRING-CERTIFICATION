package com.medici.app.spring.stereotype;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspect {

	@Pointcut("@annotation(com.medici.app.spring.stereotype.AspectAnnotation)")
	public void hasAspectAnnotation() {
	};

	@Around("hasAspectAnnotation()")
	public void aroundHasAspectAnnotation(JoinPoint joinPoint) {
		System.out.println("AnnotationAspect.aroundHasAspectAnnotation() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	@Pointcut("@target(org.springframework.cache.annotation.Caching)")
	public void hasAspectTarget() {
	};

	@Around("hasAspectTarget()")
	public void aroundHasAspectTarget(JoinPoint joinPoint) {
		System.out.println("AnnotationAspect.aroundHasAspectTarget() : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

}
