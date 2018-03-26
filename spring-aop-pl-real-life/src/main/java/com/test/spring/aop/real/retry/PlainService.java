package com.test.spring.aop.real.retry;

import org.springframework.stereotype.Service;

@Service
public class PlainService {

	public void doSomething() {
		System.out.println("Inside doSomething");
	}

}
