package com.test.spring.aop.aspect.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

	public void doIt() {
	}

	public void throwsException() {
		throw new RuntimeException();
	}

}
