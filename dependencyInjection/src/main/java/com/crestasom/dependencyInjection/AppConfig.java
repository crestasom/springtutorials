package com.crestasom.dependencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name = "car")
	public Car getCar() {
		return new Car();
	}
	
	@Bean(name = "tyre")
	public Tyre getTyre() {
		return new Tyre();
	}

}
