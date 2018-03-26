package com.test.spring.aop.aspect.compile_time_weaving.demo;

public class DemoClass {

	public void advicedMethod() {
	}

	public void callsTheAdvicedMethohd() {
		advicedMethod();
	}

}
