package com.crestasom.springmvctutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crestasom.springmvctutorial.entity.Person;
import com.crestasom.springmvctutorial.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	PersonService pService;

	@RequestMapping("/person/add")
	public String addPersonForm(Model model) {
		Person p = new Person();
		model.addAttribute("person", p);
		return "/person/add.jsp";
	}

	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person person) {
		pService.addPerson(person);
		return "redirect:/person/viewall";
	}

	@RequestMapping("/person/viewall")
	public String viewAll(Model model) {
		List<Person> plist = pService.getAllPerson();
		System.out.println(plist);
		model.addAttribute("persons", plist);
		return "/person/viewall.jsp";
	}
}
