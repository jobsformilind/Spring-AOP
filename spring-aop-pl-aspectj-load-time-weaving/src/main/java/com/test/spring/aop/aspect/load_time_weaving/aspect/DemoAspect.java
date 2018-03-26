package com.test.spring.aop.aspect.load_time_weaving.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DemoAspect {

	@Before("execution(void advicedMethod())")
	public void logException() {
		System.out.println("Aspect called!");
	}

}
