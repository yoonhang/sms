package com.example.demo;
//package net.nurigo.gradlespringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//SpringApplication.run(GradleSpringDemoApplication.class, args);
		System.out.println("sms....");
	}

}
