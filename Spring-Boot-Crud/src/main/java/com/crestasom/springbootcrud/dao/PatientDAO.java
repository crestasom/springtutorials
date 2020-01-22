package com.crestasom.springbootcrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crestasom.springbootcrud.entity.Patient;
import com.crestasom.springbootcrud.entity.Person;

public interface PatientDAO extends CrudRepository<Patient, Integer> {

	List<Patient> findAllByHospitalHosId(int id);

	@Query(value = "select * from person", nativeQuery = true)
	List<Person> findAllPerson();

}
