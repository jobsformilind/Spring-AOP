package com.test.spring.aop.real.exceptions;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionHandling {

	Logger logger = LoggerFactory.getLogger(ExceptionHandling.class);

	@AfterThrowing(pointcut = "com.test.spring.aop.real.exceptions.SystemArchitecture.Repository()", throwing = "ex")
	public void logDataAccessException(DataAccessException ex) {
		logger.error("Problem in Repositories", ex);
	}

	@AfterThrowing(pointcut = "com.test.spring.aop.real.exceptions.SystemArchitecture.Repository() || com.test.spring.aop.real.exceptions.SystemArchitecture.Service()", throwing = "ex")
	public void logRuntimeException(RuntimeException ex) {
		logger.error("RuntimeException", ex);
	}

}
