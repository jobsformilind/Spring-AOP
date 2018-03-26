package com.test.spring.aop.real.circuitbreaker;

import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerServiceImpl implements CircuitBreakerService {

  private int counter;

  @CircuitBreaker
  public void erroneousMethod() {
    counter++;
    if (counter < 2) {
      throw new RuntimeException();
    }
  }

}
