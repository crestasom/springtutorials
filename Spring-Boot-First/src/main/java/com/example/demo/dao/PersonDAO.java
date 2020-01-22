package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Person;

public interface PersonDAO extends CrudRepository<Person, Integer> {

	@Query(value = "EXEC selectAllPersonsNew", nativeQuery = true)
	List<Person> personList();

	@Query(value = "EXEC select_by_id :id", nativeQuery = true)
	Optional<Person> getPerson(@Param("id") int id);

}
