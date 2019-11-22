package com.crestasom.springcoredemo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.crestasom")
public class AppConfig {

	/*
	 * @Bean public Car getCar() { return new Car("nano"); }
	 * 
	 * @Bean public Tyre getTyre() { return new Tyre(); }
	 */
}
