package com.crestasom.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crestasom.springcrud.entity.Person;
import com.crestasom.springcrud.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService pService;

	@RequestMapping("/")
	public String getAllPerson(Model model) {
		List<Person> persons = pService.getAllPerson();
		// System.out.println(persons);
		model.addAttribute("persons", persons);
		return "person/allperson";
	}

	@RequestMapping("/add")
	public String addPersonForm(Model model) {
		model.addAttribute("action", "add");

		return "person/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(Person p, Model model) {
		p.setId(pService.getAllPerson().size());
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

	@RequestMapping(value = "/delete/{id}")
	public String deletePerson(@PathVariable int id, Model model) {
		pService.deletePerson(id);
		List<Person> persons = pService.getAllPerson();
		model.addAttribute("persons", persons);
		return "person/allperson";
	}

}
