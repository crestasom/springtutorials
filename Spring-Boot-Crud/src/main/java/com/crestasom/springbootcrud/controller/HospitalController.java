package com.crestasom.springbootcrud.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.springbootcrud.entity.Hospital;
import com.crestasom.springbootcrud.entity.Patient;
import com.crestasom.springbootcrud.service.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hSevice;

	@RequestMapping({ "/", "/index" })
	public List<Hospital> getAllHospital() {
		return hSevice.getAllHospital();
	}

	@RequestMapping({ "/{id}" })
	public Hospital getHospital(@PathVariable int id) {
		return hSevice.getHospital(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<Hospital> addHospital(@Valid @RequestBody Hospital h) {
		System.out.println(h);
		hSevice.addHospital(h);
		return hSevice.getAllHospital();
	}

	@RequestMapping(value = "/remove/{id}")
	public List<Hospital> removeHospital(@PathVariable int id) {
		System.out.println("Remove Invoked");
		hSevice.removeHospital(id);
		return hSevice.getAllHospital();
	}

	@RequestMapping("/patient/{id}")
	public List<Patient> getAllPatient(@PathVariable("id") int hospId) {
		return hSevice.allPatient(hospId);
	}

	@RequestMapping("/avg-sal/{id}")
	public Map<String, Double> getAvgSalary(@PathVariable("id") int hospId) {
		System.out.println(hSevice.getAvgSalary(hospId).toString());
		return hSevice.getAvgSalary(hospId);
	}
}
