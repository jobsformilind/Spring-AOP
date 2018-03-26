package com.test.spring.aop.library.tracing.service;

import org.springframework.stereotype.Service;

@Service
public class PlainService {

	public void doSomething() {
		System.out.println("PlainService.doSomething() is called...");
	}
}
