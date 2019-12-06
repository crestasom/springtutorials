package com.crestasom.multidb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.multidb.book.model.Book;
import com.crestasom.multidb.book.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	public List<Book> getAllBooks() {
		List<Book> bList = new ArrayList<Book>();
		bookRepo.findAll().forEach(b -> bList.add(b));
		return bList;
	}

}
