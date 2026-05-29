package com.example.demo.controller;

import com.example.demo.service.ArithService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arith")
public class Arith {
  private final ArithService arithService;

  public Arith(ArithService arithService) {
    this.arithService = arithService;
  }

  @GetMapping("/add")
  public long sum_between_a_and_b(long a, long b) {
    return arithService.arith_add(a, b);
  }

  @GetMapping("/substract")
  public long substraction_between_a_and_b(long a, long b) {
    return arithService.arrith_substraction(a, b);
  }

  @GetMapping("/division")
  public double divion_between_a_and_b(double a, double b) {
    return arithService.arrith_division(a, b);
  }

  @GetMapping("/multiplication")
  public long multiplication_between_a_and_b(long a, long b) {
    return arithService.arrith_multiplication(a, b);
  }
}
