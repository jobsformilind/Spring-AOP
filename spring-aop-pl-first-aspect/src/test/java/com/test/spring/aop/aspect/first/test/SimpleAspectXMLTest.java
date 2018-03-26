package com.test.spring.aop.aspect.first.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.aop.aspect.first.BeforeAdvice;
import com.test.spring.aop.aspect.first.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/aspect.xml")
public class SimpleAspectXMLTest {

	@Autowired
	BeforeAdvice tracingAspect;

	@Autowired
	SimpleService simpleService;

	@Test
	public void aspectIsCalled() {
		assertFalse(tracingAspect.isEnteringCalled());
		simpleService.doSomethingElse();
		assertTrue(tracingAspect.isEnteringCalled());
	}
}
