package com.test.spring.aop.real.retry;

import org.springframework.stereotype.Service;

@Service
public class ErroneousService {

	private boolean throwException = true;

	public void throwException() {
		if (throwException) {
			throwException = false;
			System.out.println("Throwing exception");
			throw new RuntimeException();
		} else {
			System.out.println("After exception thrown");
			throwException = true;
		}
	}

}
