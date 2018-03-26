package com.test.spring.aop.real.datacapture;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(basePackages="com.test.spring.aop.real.datacapture")
public class SystemConfiguration {

}
