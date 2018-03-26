package com.test.spring.aop.aspect.annotation;

import org.aspectj.lang.annotation.Pointcut;

public class SystemArchitectureForPackages {

	// Rest of the classes will remain same as for annotations
	@Pointcut("execution(* com.ewolff..repository.*Repository.*(..))")
	public void Repository() {
	}

	@Pointcut("execution(* com.ewolff..service.*.*(..))")
	public void Service() {
	}

}
