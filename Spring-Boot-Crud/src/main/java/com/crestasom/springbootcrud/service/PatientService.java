package com.crestasom.springbootcrud.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.springbootcrud.dao.PatientDAO;
import com.crestasom.springbootcrud.entity.Patient;
import com.crestasom.springbootcrud.entity.Doctor;
import com.crestasom.springbootcrud.entity.Hospital;

@Service
public class PatientService {
	@Autowired
	private PatientDAO patientDao;

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private DoctorService doctorService;

	public List<Patient> getAllPatient() {
		List<Patient> patList = new ArrayList<>();
		patientDao.findAll().forEach(patList::add);
		/*
		 * Iterable<Patient> docL = patientDao.findAllByWorkHospActive(true);
		 * Iterator<Patient> i = docL.iterator(); while (i.hasNext()) {
		 * doctList.add(i.next()); }
		 */
		return patList;
	}

	public Patient getPatient(int id) {
		return patientDao.findById(id).get();
	}

	public void addPatient(Patient p) {
		Hospital h = hospitalService.getHospital(p.getHospId());
		p.setHospital(h);
		Doctor d = doctorService.get(p.getDoctId());
		p.setDoctor(d);
		System.out.println(d);
		patientDao.save(p);
	}

	public void deletePatient(int id) {
		patientDao.deleteById(id);
	}

	public List<Patient> getPatientsByHospital(int hosId) {
		return patientDao.findAllByHospitalHosId(hosId);
	}

}
