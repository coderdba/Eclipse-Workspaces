package com.gm.rest.spring.ComGmSpringBoot1Jar.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorldController {

  //@GetMapping
  @GetMapping("/helloworld")
  String hello() {
    return "Hello World! Spring Boot1";
  }
}