package com.test.spring.aop.aspect.first.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.aop.aspect.first.AfterAdvice;
import com.test.spring.aop.aspect.first.SimpleAspectConfiguration;
import com.test.spring.aop.aspect.first.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleAspectConfiguration.class)
public class AfterAdviceTest {

	@Autowired
	AfterAdvice afterAdvice;

	@Autowired
	SimpleService simpleService;

	@Before
	public void reset() {
		afterAdvice.reset();
	}

	@Test
	public void afterAspectIsCalledIfMethodReturnsSuccessfully() {
		assertFalse(afterAdvice.isAfterCalled());
		simpleService.doSomething();
		assertTrue(afterAdvice.isAfterCalled());
	}

	@Test(expected = RuntimeException.class)
	public void afterAspectIsCalledIfMethodThrowsException() {
		assertFalse(afterAdvice.isAfterCalled());
		try {
			simpleService.throwsRuntimeException();
		} finally {
			assertTrue(afterAdvice.isAfterCalled());
		}
	}

}
