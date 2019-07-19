package com.medici.app.spring.stereotype;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StandAloneAspect {

	@After("@within(com.medici.app.spring.stereotype.StandAloneAnnotation)")
	public void adviceAtWithin(JoinPoint thisJoinPoint) {
		System.out.println("StandAloneAspect[@within] " + thisJoinPoint);
	}

	@After("@target(com.medici.app.spring.stereotype.StandAloneAnnotation)")
	public void adviceAtTarget(JoinPoint thisJoinPoint) {
		System.out.println("StandAloneAspect[@target] " + thisJoinPoint);
	}

	@Pointcut("execution(* com.medici.app.spring.stand.*.*.*.*(..)) && args(request)")
	public void pointcutArgs(List<Long> request) {
	}

	@After("pointcutArgs(request)")
	public void afterpointcutArgs(JoinPoint thisJoinPoint, List<Long> request) {
		System.out.println("StandAloneAspect.afterpointcutArgs[@target] " + thisJoinPoint);
	}

}
