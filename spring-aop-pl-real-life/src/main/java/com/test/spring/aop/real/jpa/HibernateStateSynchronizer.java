package com.test.spring.aop.real.jpa;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class HibernateStateSynchronizer {

	@Autowired
	private SessionFactory sessionFactory;

	@Before("execution(* org.springframework.jdbc.core.JdbcTemplate.*(..) )")
	public void flush() {
		if (sessionFactory != null) {
			Session session = sessionFactory.getCurrentSession();
			if (session != null && session.isDirty()) {
				session.flush();
			}
		}
	}

}
