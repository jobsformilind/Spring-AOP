package com.test.spring.aop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

	@Autowired
	SimpleRepository repository;

	public DomainObject service() {
		System.out.println("Invoking service method...");
		return repository.findDomainObject();
	}
}
