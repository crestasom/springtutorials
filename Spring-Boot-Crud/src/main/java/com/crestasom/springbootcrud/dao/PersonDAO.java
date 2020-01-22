package com.crestasom.springbootcrud.dao;

import org.springframework.data.repository.CrudRepository;

import com.crestasom.springbootcrud.entity.Person;

public interface PersonDAO extends CrudRepository<Person, Integer> {

}
