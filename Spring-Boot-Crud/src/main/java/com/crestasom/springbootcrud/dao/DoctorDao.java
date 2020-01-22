package com.crestasom.springbootcrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crestasom.springbootcrud.entity.Doctor;

public interface DoctorDao extends CrudRepository<Doctor, Integer> {
	public Iterable<Doctor> findAllByWorkHospActive(boolean status);

	public List<Doctor> findAllByWorkHospHosId(int id);

	/*
	 * @Query("Select d.dName,h.hName from hospital h inner join h.doctorList d")
	 * List<Object> getAllRecords();
	 */

	@Query(value = "Select @@SPID", nativeQuery = true)
	List<Object> getTest();
}
