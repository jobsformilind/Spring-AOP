package com.test.spring.aop.real.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountFilterAspect {

	private ThreadLocal<Customer> currentCustomer = new ThreadLocal<Customer>();

	private Customer getCurrentCustomer() {
		return currentCustomer.get();
	}

	public void setCurrentCustomer(Customer customer) {
		currentCustomer.set(customer);
	}

	public void clearCurrentCustomer() {
		currentCustomer.set(null);
	}

	@Around("execution(com.test.spring.aop.real.filter.Account *(..))")
	public Object filterAccount(ProceedingJoinPoint joinPoint) throws Throwable {
		Customer customer = getCurrentCustomer();
		if (customer == null) {
			return null;
		}
		Account result = (Account) joinPoint.proceed();
		if (customer.getFirstname().equals(result.getFirstname()) && customer.getName().equals(result.getName())) {
			return result;
		} else {
			return null;
		}
	}
}
