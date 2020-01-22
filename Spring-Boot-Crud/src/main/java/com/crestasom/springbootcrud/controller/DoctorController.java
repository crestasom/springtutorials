package com.crestasom.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.springbootcrud.entity.Doctor;
import com.crestasom.springbootcrud.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService dService;

	@RequestMapping({ "/", "/index" })
	public List<Doctor> getAllDoctor() {
		System.out.println(dService.getAll());
		return dService.getAll();

	}

	@RequestMapping({ "/{id}" })
	public Doctor getDoctor(@PathVariable int id) {
		return dService.get(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<Doctor> addDoctor(@RequestBody Doctor d) {
		dService.add(d);
		return dService.getAll();
	}

	@RequestMapping("/delete/{id}")
	public List<Doctor> deleteDoctor(@PathVariable int id) {
		dService.deleteById(id);
		return dService.getAll();
	}

	

}
