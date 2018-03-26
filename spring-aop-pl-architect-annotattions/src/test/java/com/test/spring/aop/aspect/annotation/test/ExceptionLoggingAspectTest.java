package com.test.spring.aop.aspect.annotation.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.aop.aspect.annotation.aspects.ExceptionLoggingAspect;
import com.test.spring.aop.aspect.annotation.repository.MyRepository;
import com.test.spring.aop.aspect.annotation.service.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/system-configuration.xml")
public class ExceptionLoggingAspectTest {

	@Autowired
	ExceptionLoggingAspect exceptionLoggingAspect;

	@Autowired
	MyService myService;

	@Autowired
	MyRepository myRepository;

	@Before
	public void setUp() {
		exceptionLoggingAspect.resetCalled();
	}

	@Test
	public void exceptionLoggingIsNotCalledIfNoExceptionIsThrown() {
		assertFalse(exceptionLoggingAspect.isCalled());
		myRepository.doIt();
		assertFalse(exceptionLoggingAspect.isCalled());
	}

	@Test(expected = RuntimeException.class)
	public void exceptionLoggingIsCalledIfExceptionIsThrown() {
		assertFalse(exceptionLoggingAspect.isCalled());
		try {
			myRepository.throwsException();
		} finally {
			assertTrue(exceptionLoggingAspect.isCalled());
		}
	}

}
