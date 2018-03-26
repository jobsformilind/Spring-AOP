package com.test.spring.aop.aspect.compile_time_weaving.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.test.spring.aop.aspect.compile_time_weaving.aspect.DemoAspect;
import com.test.spring.aop.aspect.compile_time_weaving.demo.DemoClass;

public class AspectTest {

	@Test
	public void adviceIsCalled() {
		assertFalse(DemoAspect.isCalled());
		DemoClass demoClass = new DemoClass();
		demoClass.advicedMethod();
		assertTrue(DemoAspect.isCalled());
	}
}
