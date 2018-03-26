package com.test.spring.aop.real.datacapture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.aop.real.datacapture.PlainService;
import com.test.spring.aop.real.datacapture.SystemConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class DataCaptureTest {

	@Autowired
	private PlainService plainServer;

	@Test(expected = RuntimeException.class)
	public void test() {
		plainServer.doIt(42);
	}
}
