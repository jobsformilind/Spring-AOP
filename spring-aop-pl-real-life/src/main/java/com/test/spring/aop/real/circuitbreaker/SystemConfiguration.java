package com.test.spring.aop.real.circuitbreaker;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "com.test.spring.aop.real.circuitbreaker")
public class SystemConfiguration {

}
