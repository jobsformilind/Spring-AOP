package com.test.spring.aop.real.datacapture;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FirstFailureDataCaptureAspect {

	private ThreadLocal<CallContext> callContext = new ThreadLocal<CallContext>();

	private CallContext getCallContext() {
		CallContext result = callContext.get();
		if (result == null) {
			callContext.set(new CallContext());
			result = callContext.get();
		}
		return result;
	}

	@AfterThrowing(value = "com.test.spring.aop.real.datacapture.SystemArchitecture.Service()", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		getCallContext().afterThrowing(ex);
	}

	@Before("com.test.spring.aop.real.datacapture.SystemArchitecture.Service()")
	public void before(JoinPoint joinPoint) {
		getCallContext().before(joinPoint);
	}

	@AfterReturning(pointcut="com.test.spring.aop.real.datacapture.SystemArchitecture.Service()", returning="result")
	public void afterReturning(Object result) {
		getCallContext().afterReturning(result);
	}

}
