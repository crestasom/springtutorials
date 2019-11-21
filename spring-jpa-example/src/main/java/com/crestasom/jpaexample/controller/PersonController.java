package com.crestasom.jpaexample.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crestasom.jpaexample.entity.Department;
import com.crestasom.jpaexample.entity.Person;
import com.crestasom.jpaexample.service.DepartmentService;
import com.crestasom.jpaexample.service.PersonService;

@Controller("")
public class PersonController {
	@Autowired
	private PersonService pService;
	@Autowired
	private DepartmentService dService;

	@RequestMapping("/person/hello")
	public String sayHi() {
		// Person p = new Person("Sam", "Shrestha", "crestasam@gmail.com");
		// pService.addPerson(p);
		System.out.println("I am here");
		return "hello";
	}

	@RequestMapping("/person")
	public ModelAndView getAllPersons() {
		ModelAndView mv = new ModelAndView();
		List<Person> pList = pService.getAllPerson();
		mv.setViewName("person/viewall");
		mv.addObject("personList", pList);
		return mv;
	}

	/*
	 * @RequestMapping("/person/add") public ModelAndView addPersonForm() {
	 * ModelAndView mv = new ModelAndView(); Set<Department> departments =
	 * dService.getAllDepList(); mv.setViewName("person/add"); mv.addObject("flag",
	 * false); mv.addObject("department", departments); return mv; }
	 */
	// using thymeleaf
	@RequestMapping("/person/add")
	public String addPersonForm(Person person, Model model) {
		Set<Department> departments = dService.getAllDepList();
		// mv.setViewName("person/add");
		// mv.addObject("flag", false);
		// mv.addObject("department", departments);
		model.addAttribute("departments", departments);
		return "person/add-person";
	}

	/*
	 * @RequestMapping(value = "/person/add", method = RequestMethod.POST) public
	 * String addPerson(@RequestParam("first_name") String
	 * fName, @RequestParam("last_name") String lName,
	 * 
	 * @RequestParam("email") String email, @RequestParam("department") String dep)
	 * { Department department = dService.getDepartment(Integer.parseInt(dep));
	 * Person p = new Person(fName, lName, email, new Date());
	 * p.setDepartment(department); pService.addPerson(p); return
	 * "redirect:/person"; }
	 */
	// using thymeleaf
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@Valid Person p, BindingResult result, Model model, @RequestParam("dept_id") int id) {
		if (result.hasErrors()) {
			return "add-user";
		}
		p.setDepartment(dService.getDepartment(id));
		pService.addPerson(p);
		return "redirect:/person/index";
	}

	@RequestMapping("/person/delete/{id}")
	public String deletePerson(@PathVariable int id) {
		System.out.println("I am here in person controller");
		pService.deletePerson(id);
		return "redirect:/person/index";
	}

	/*
	 * @RequestMapping("/person/update/{id}") public ModelAndView
	 * updatePerson(@PathVariable String id) { ModelAndView mv = new ModelAndView();
	 * Person p = pService.getPerson(Integer.parseInt(id)); mv.addObject("flag",
	 * false); mv.addObject("person", p); mv.setViewName("person/add");
	 * mv.addObject("flag", false); return mv; }
	 */

	@RequestMapping("/person/update/{id}")
	public String updatePersonForm(@PathVariable int id, Model model) {
		System.out.println("Test1");
		Person p = pService.getPerson(id);

		model.addAttribute("person", p);
		Set<Department> departments = dService.getAllDepList();
		model.addAttribute("departments", departments);
		return "/person/update";
	}

	@RequestMapping(value = "/person/update/{id}", method = RequestMethod.POST)
	public String updatePerson(@Valid Person p, BindingResult result, Model model, @RequestParam("dept_id") int id) {
		// System.out.println("Test1");
		if (result.hasErrors()) {
			return "/person/update";
		}
		p.setDepartment(dService.getDepartment(id));
		pService.addPerson(p);
		return "redirect:/person/index";
	}

	@RequestMapping("person/index")
	public String index(Model model) {
		List<Person> persons = pService.getAllPerson();
		model.addAttribute("persons", persons);
		return "person/index";
	}

}
