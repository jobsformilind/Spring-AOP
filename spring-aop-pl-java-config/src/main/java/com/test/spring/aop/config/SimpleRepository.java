package com.test.spring.aop.config;

import org.springframework.stereotype.Repository;

@Repository
public class SimpleRepository {

	public DomainObject findDomainObject() {
		return new DomainObject();
	}

}
