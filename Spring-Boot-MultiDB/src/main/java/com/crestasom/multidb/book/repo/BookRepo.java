package com.crestasom.multidb.book.repo;

import org.springframework.data.repository.CrudRepository;

import com.crestasom.multidb.book.model.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {

}
