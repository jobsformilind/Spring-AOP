package com.test.spring.aop.aspect.objectadd.demo;

import org.springframework.transaction.annotation.Transactional;

public class TxExample {

	@Transactional
	public void transactionalMethod() {
	}

	public void callsTransactionalMethod() {
		transactionalMethod();
	}

}
