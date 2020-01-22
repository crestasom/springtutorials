package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public Person sayHi() {
		Person p = new Person("ram", "ram@mail.com");

		return p;
	}

	@RequestMapping("/test-hello21")
	public String sayHello() {
		return "Hello";
	}

}

class Person {
	String name, address;

	public Person(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}