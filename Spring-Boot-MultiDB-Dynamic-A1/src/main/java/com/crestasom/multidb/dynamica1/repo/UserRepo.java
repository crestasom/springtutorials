package com.crestasom.multidb.dynamica1.repo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo<T, ID> extends CrudRepository<T, ID>{

}
