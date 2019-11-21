package com.crestasom.jpaexample.test;

import org.springframework.data.repository.CrudRepository;

public interface AccountDao extends CrudRepository<AccountEntity, Integer> {

}
