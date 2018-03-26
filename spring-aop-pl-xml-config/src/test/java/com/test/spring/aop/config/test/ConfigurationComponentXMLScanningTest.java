package com.test.spring.aop.config.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.aop.config.DomainObject;
import com.test.spring.aop.config.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/component-scanning.xml")
public class ConfigurationComponentXMLScanningTest {

	@Autowired
	private SimpleService simpleService;

	@Test
	public void dependencyInjectionShouldWork() {
		assertNotNull(simpleService);
	}

	@Test
	public void serviceShouldReturnDomainObject() {
		assertThat(simpleService.service(), equalTo(new DomainObject()));
	}

}
