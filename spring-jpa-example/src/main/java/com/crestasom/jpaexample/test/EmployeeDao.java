package com.crestasom.jpaexample.test;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<EmployeeEntity, Integer> {

}
