package com.crestasom.springbootcrud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.springbootcrud.dao.DoctorDao;
import com.crestasom.springbootcrud.entity.Doctor;
import com.crestasom.springbootcrud.entity.Hospital;

@Service
public class DoctorService extends SuperService<Doctor, Integer> {
	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private HospitalService hospitalService;

	public DoctorService() {
		System.out.println("Dao " + dao);
	}

	public List<Doctor> getAllDoctorsByHospital(int hosId) {
		return doctorDao.findAllByWorkHospHosId(hosId);

	}

}
