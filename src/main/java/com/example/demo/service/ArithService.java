package com.example.demo.service;

import static java.lang.Float.NaN;

import org.springframework.stereotype.Service;

@Service
public class ArithService {
  public long arith_add(long a, long b) {
    int sum = 0;
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("number must be positive");
    }

    return a + b;
  }

  public long arrith_substraction(long a, long b) {

    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("number must be positive");
    }

    return a - b;
  }

  public double arrith_division(double a, double b) {


    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("number must be positive");
    }
    if (b == 0) {
      return NaN;
    }

    return a / b;
  }

  public long arrith_multiplication(long a, long b) {

    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("number must be positive");
    }

    return a * b;
  }
}
