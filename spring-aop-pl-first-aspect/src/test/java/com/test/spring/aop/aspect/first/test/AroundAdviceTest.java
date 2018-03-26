package com.test.spring.aop.aspect.first.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.aop.aspect.first.AroundAdvice;
import com.test.spring.aop.aspect.first.SimpleAspectConfiguration;
import com.test.spring.aop.aspect.first.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleAspectConfiguration.class)
public class AroundAdviceTest {

	@Autowired
	AroundAdvice aroundAspect;

	@Autowired
	SimpleService simpleService;

	@Before
	public void rest() {
		aroundAspect.reset();
	}

	@Test
	public void aroundAdviceIsCalledForSimpleMethod() {
		assertFalse(aroundAspect.isCalled());
		simpleService.doSomething();
		assertTrue(aroundAspect.isCalled());
	}

	@Test(expected = RuntimeException.class)
	public void aroundAdviceIsCalledIfExceptionIsThrown() {
		assertFalse(aroundAspect.isCalled());
		try {
			simpleService.throwsRuntimeException();
		} finally {
			assertTrue(aroundAspect.isCalled());
		}
	}

	@Test
	public void aroundAdviceIsCalledIfValueIsReturned() {
		assertFalse(aroundAspect.isCalled());
		assertThat(simpleService.returnsString(), equalTo("42"));
		assertTrue(aroundAspect.isCalled());
	}

}
