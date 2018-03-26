package com.test.spring.aop.aspect.objectadd.demo;

import org.springframework.stereotype.Component;

@Component
public class DemoClass {

	public void advicedMethod() {

	}

	public void callsTheAdvicedMethod() {
		advicedMethod();
	}
}
