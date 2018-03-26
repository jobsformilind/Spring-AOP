package com.test.spring.aop.real.exceptions;

import org.springframework.stereotype.Service;

@Service
public class ErroneousService {

	private boolean throwException = true;

	public void throwException() {
		if (throwException) {
			throwException = false;
			throw new RuntimeException();
		} else {
			throwException = true;
		}
	}

}
