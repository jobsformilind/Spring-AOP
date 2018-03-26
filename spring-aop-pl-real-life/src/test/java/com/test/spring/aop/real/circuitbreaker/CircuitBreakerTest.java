package com.test.spring.aop.real.circuitbreaker;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.aop.real.circuitbreaker.CircuitBreakerService;
import com.test.spring.aop.real.circuitbreaker.CircuitBreakerServiceImpl;
import com.test.spring.aop.real.circuitbreaker.CircuitBreakerServiceImpl2;
import com.test.spring.aop.real.circuitbreaker.SystemConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class CircuitBreakerTest {

	@Autowired
	private CircuitBreakerServiceImpl circuitBreakerServiceImpl;

	@Autowired
	private CircuitBreakerServiceImpl2 circuitBreakerServiceImpl2;

	public void methodShouldExecuteWithoutExceptionAfter10Tries(CircuitBreakerService service) {
		for (int i = 0; i < 9; i++) {
			try {
				service.erroneousMethod();
				fail("Expected failure in iteration " + i + " !");
			} catch (RuntimeException ex) {
			}
		}
		service.erroneousMethod();
	}

	@Test
	public void restErroneousService2() {
		methodShouldExecuteWithoutExceptionAfter10Tries(circuitBreakerServiceImpl2);
	}

	@Test
	public void restErroneousService() {
		methodShouldExecuteWithoutExceptionAfter10Tries(circuitBreakerServiceImpl);
	}

}
