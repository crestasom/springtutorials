package com.crestasom.springbootcrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.springbootcrud.service.PersonService;
import com.crestasom.springbootcrud.entity.Person;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService pService;

	@RequestMapping({ "/", "/index" })
	public List<Person> getAllPerson(Model model) {
		List<Person> persons = pService.getAll();
		System.out.println(persons);
		return persons;
	}

	@RequestMapping("/{id}")
	public Person getPerson(@PathVariable int id) {
		Person p = pService.get(id);
		return p;
	}

	@RequestMapping("/add")
	public String addPersonForm(Model model) {
		model.addAttribute("action", "add");
		return "person/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<Person> addPerson(@RequestBody Person p) {

		/*
		 * if (results.hasErrors()) { return "person/add"; }
		 */

		System.out.println(p);
		// p.setId(pService.getAllPerson().size());
		pService.add(p);
		return pService.getAll();
	}

	@RequestMapping("/update/{id}")
	public String updatePersonForm(@PathVariable int id, Model model) {
		model.addAttribute("person", pService.get(id));
		model.addAttribute("action", id + "");
		return "/WEB-INF/person/add.jsp";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updatePerson(Person p, Model model) {
		pService.add(p);
		return "redirect:/person/";
	}

	@RequestMapping(value = "/delete/{id}")
	public List<Person> deletePerson(@PathVariable int id) {
		pService.deleteById(id);
		List<Person> persons = pService.getAll();

		return persons;
	}

}
