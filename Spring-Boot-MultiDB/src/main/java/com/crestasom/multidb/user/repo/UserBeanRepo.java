package com.crestasom.multidb.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crestasom.multidb.user.model.User;

@Repository
public interface UserBeanRepo extends CrudRepository<User, Integer> {

}
