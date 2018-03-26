package com.test.spring.aop.aspect.load_time_weaving.demo;

public class CallAdvicedMethod {

	public static void main(String[] args) {
		DemoClass demoClass = new DemoClass();
		demoClass.advicedMethod();
	}
}
