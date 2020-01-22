package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController1 {
	@RequestMapping("test-hello")
	public String sayHello() {
		return "Hello";
	}

}
