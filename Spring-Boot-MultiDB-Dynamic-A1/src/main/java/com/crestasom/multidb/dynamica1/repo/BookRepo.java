package com.crestasom.multidb.dynamica1.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo<T, ID> extends CrudRepository<T, ID> {

	Optional<T> findByName(String name);

	@Query(value = "Select * from Book", nativeQuery = true)
	List<T> getAllBook();
	

}
