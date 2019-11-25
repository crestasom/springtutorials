package com.crestasom.springcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHi() {
		System.out.println("I am here");
		return "/WEB-INF/views/hello.jsp";
	}

}
