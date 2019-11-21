package com.crestasom.jpaexample.dao;

import org.springframework.data.repository.CrudRepository;

import com.crestasom.jpaexample.entity.Department;

public interface DepartmentDao extends CrudRepository<Department, Integer> {

}
