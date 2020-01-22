package com.crestasom.springbootcrud.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.crestasom.springbootcrud.entity.Hospital;

public interface HospitalDao extends CrudRepository<Hospital, Integer> {
	public Iterable<Hospital> findAllByActive(boolean active);

	@Transactional
	@Modifying
	@Query("UPDATE hospital SET active=false where h_id=:id")
	public void setHospitalInactive(@Param("id") int id);
}
