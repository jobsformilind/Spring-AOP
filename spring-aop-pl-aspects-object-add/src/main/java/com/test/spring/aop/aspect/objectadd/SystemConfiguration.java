package com.test.spring.aop.aspect.objectadd;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.test.spring.aop.aspect.objectadd")
public class SystemConfiguration {

}
