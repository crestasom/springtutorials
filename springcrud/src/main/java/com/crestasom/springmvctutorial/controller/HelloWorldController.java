package com.crestasom.springmvctutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/add")
public class HelloWorldController {

	@RequestMapping("/hello")
	public String sayHi(@RequestParam("num1") int i1, @RequestParam("num2") int i2, Model model) {
		int i3 = i1 + i2;
		model.addAttribute("i3", i3);

		return "hello.jsp";
	}

}
