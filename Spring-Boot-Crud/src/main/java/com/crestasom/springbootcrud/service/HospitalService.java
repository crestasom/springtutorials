package com.crestasom.springbootcrud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crestasom.springbootcrud.dao.HospitalDao;
import com.crestasom.springbootcrud.entity.Doctor;
import com.crestasom.springbootcrud.entity.Hospital;
import com.crestasom.springbootcrud.entity.Patient;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao hospitalDao;

	@Autowired
	private PatientService patientService;

	@Autowired
	private DoctorService doctorService;

	public List<Hospital> getAllHospital() {
		List<Hospital> hospList = new ArrayList<Hospital>();
		hospitalDao.findAllByActive(true).forEach(hospList::add);
		System.out.println(hospitalDao.findAllByActive(true));
		return hospList;
	}

	public Hospital getHospital(int id) {
		return hospitalDao.findById(id).get();
	}

	public void addHospital(Hospital h) {
		hospitalDao.save(h);
	}

	public void removeHospital(int id) {
		hospitalDao.setHospitalInactive(id);
	}

	public List<Patient> allPatient(int id) {
		return patientService.getPatientsByHospital(id);
		// return hospitalDao.findById(id).get().getPatientList();

	}

	public Map<String, Double> getAvgSalary(int hospid) {
		List<Doctor> doctors = doctorService.getAllDoctorsByHospital(hospid);
		Map<String, Double> result = new HashMap<String, Double>();
		double avg = 100.0D, total = 0.0;
		result.put("Average Salary", avg / 1);
		if (doctors != null) {
			for (Doctor d : doctors) {
				total += d.getdSalary();
			}
			avg = total / doctors.size();
		}
		result.put("Average Salary", avg / 1);
		return result;
	}

}
