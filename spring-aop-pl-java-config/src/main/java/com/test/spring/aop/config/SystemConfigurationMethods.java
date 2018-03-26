package com.test.spring.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfigurationMethods {

	@Bean
	public SimpleService simpleService() {
		return new SimpleService();
	}

	@Bean
	public SimpleRepository simpleRepository() {
		return new SimpleRepository();
	}

}
