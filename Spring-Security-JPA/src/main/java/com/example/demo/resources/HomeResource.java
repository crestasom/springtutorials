package com.example.demo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@RequestMapping("/")
	public String sayHi() {
		return "<h2>hi</h2>";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "<h2>hello admin</h2>";
	}

	@RequestMapping("/user")
	public String user() {
		return "<h2>hello user</h2>";
	}

}
