package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService pService;

	@RequestMapping("/")
	public String getAllPersons(Model model) {

		List<Person> pList = pService.getAllPerson();
		model.addAttribute("persons", pList);
		return "person/index";
	}

	@RequestMapping("/add")
	public String addPersonForm(Person person) {
		System.out.println("inside form request");
		return "person/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@Valid @ModelAttribute("person") Person p, BindingResult results) {
		System.out.println("Person:" + p);
		if (results.hasErrors()) {
			return "person/add";
		}
		pService.addPerson(p);
		return "redirect:/person/";
	}

	@RequestMapping("/update/{id}")
	public String updatePersonForm(@PathVariable int id, Model model) {
		model.addAttribute("person", pService.getPerson(id));
		model.addAttribute("action", id + "");
		return "person/add";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updatePerson(Person p, Model model) {
		pService.updatePerson(p);
		return "redirect:/person/";
	}

	@RequestMapping(value = "/delete")
	public String deletePerson(@RequestParam("id") int id, Model model) {
		pService.deletePerson(id);
		List<Person> persons = pService.getAllPerson();
		model.addAttribute("persons", persons);
		return "redirect:/person/";
	}

}
