package com.crestasom.multidb.dynamica1.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CopyRepo<T, ID> extends CrudRepository<T, ID> {

	//@Query(value = "Select * from copy where book_bId=:id", nativeQuery = true)
	List<T> findAllByBookId(int id);

}
