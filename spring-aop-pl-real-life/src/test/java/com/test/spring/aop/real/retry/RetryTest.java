package com.test.spring.aop.real.retry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class RetryTest {

	@Autowired
	ErroneousService erroneousService;

	@Autowired
	PlainService plainService;

	@Test
	public void withSpringErroneousServiceIsRetriedNoExceptionThrown() {
		erroneousService.throwException();
	}

	@Test
	public void withSpringPlainService() {
		plainService.doSomething();
	}

	@Test(expected = RuntimeException.class)
	public void withoutSpringErroneousServiceThrowsException() {
		ErroneousService erroneousService = new ErroneousService();
		erroneousService.throwException();
	}

}
