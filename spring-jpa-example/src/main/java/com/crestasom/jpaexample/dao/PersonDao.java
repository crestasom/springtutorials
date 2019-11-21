package com.crestasom.jpaexample.dao;

import org.springframework.data.repository.CrudRepository;

import com.crestasom.jpaexample.entity.Person;

public interface PersonDao extends CrudRepository<Person, Integer> {

}
