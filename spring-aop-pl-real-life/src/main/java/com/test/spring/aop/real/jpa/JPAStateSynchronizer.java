package com.test.spring.aop.real.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class JPAStateSynchronizer {

	@PersistenceContext
	private EntityManager entityManager;

	@Before("execution(* org.springframework.jdbc.core.JdbcTemplate.*(..) )")
	public void flush() {
		if (entityManager != null) {
			entityManager.flush();
		}
	}

}
