package com.crestasom.springwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello(Model model, @RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		int num3 = num1 + num2;
		System.out.println(num3);
		model.addAttribute("num3", num3);
		return "hello.jsp";
	}

}
