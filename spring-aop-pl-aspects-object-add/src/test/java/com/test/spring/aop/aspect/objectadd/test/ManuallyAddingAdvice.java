package com.test.spring.aop.aspect.objectadd.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.test.spring.aop.aspect.objectadd.DemoAspect;
import com.test.spring.aop.aspect.objectadd.demo.DemoClass;

public class ManuallyAddingAdvice {

	@Test
	public void addedAdviceIsCalled() {
		DemoAspect demoAspect = new DemoAspect();
		DemoClass originalObject = new DemoClass();
		AspectJProxyFactory proxyFactory = new AspectJProxyFactory(originalObject);
		proxyFactory.addAspect(demoAspect);
		DemoClass proxy = proxyFactory.getProxy();
		assertFalse(demoAspect.isCalled());
		proxy.advicedMethod();
		assertTrue(demoAspect.isCalled());
	}
}
