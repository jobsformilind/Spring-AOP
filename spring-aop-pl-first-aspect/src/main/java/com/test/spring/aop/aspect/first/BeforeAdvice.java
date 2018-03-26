package com.test.spring.aop.aspect.first;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAdvice {
	Logger logger = LoggerFactory.getLogger(BeforeAdvice.class);
	boolean enteringCalled = false;

	public boolean isEnteringCalled() {
		return enteringCalled;
	}

	@Before("execution(* *(..))")
	public void entering(JoinPoint joinPoint) {
		enteringCalled = true;
		logger.trace("entering " + joinPoint.getStaticPart().getSignature().toString());
	}
}
