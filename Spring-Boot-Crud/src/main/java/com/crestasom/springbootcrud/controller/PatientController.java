package com.crestasom.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.springbootcrud.entity.Patient;
import com.crestasom.springbootcrud.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService dService;

	@RequestMapping({ "/", "/index" })
	public List<Patient> getAllPatient() {
		return dService.getAllPatient();
	}

	@RequestMapping({ "/{id}" })
	public Patient getPatient(@PathVariable int id) {
		return dService.getPatient(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<Patient> addPatient(@RequestBody Patient d) {
		dService.addPatient(d);
		return dService.getAllPatient();
	}

	@RequestMapping("/delete/{id}")
	public List<Patient> deletePatient(@PathVariable int id) {
		dService.deletePatient(id);
		return dService.getAllPatient();
	}

}
