package com.test.spring.aop.aspect.objectadd.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.aop.aspect.objectadd.DemoAspect;
import com.test.spring.aop.aspect.objectadd.SystemConfiguration;
import com.test.spring.aop.aspect.objectadd.demo.DemoClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class DemoTest {

	@Autowired
	DemoAspect demoAspect;

	@Autowired
	DemoClass demoClass;

	@Before
	public void setUp() {
		demoAspect.resetCalled();
	}

	@Test
	public void directCallToAdvicedMethodIsTraced() {
		assertFalse(demoAspect.isCalled());
		demoClass.advicedMethod();
		assertTrue(demoAspect.isCalled());
	}

	@Test
	public void indirectCallToAdvicedMethodIsNotTraced() {
		assertFalse(demoAspect.isCalled());
		demoClass.callsTheAdvicedMethod();
		assertFalse(demoAspect.isCalled());
	}
}
