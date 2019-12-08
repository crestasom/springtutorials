package com.crestasom.multidb.dynamica1.sutra1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.multidb.dynamica1.model.Book;
import com.crestasom.multidb.dynamica1.sutra1.model.Sutra1Book;
import com.crestasom.multidb.dynamica1.sutra1.service.Sutra1BookService;

@RestController
@RequestMapping("/sutra1")
public class Sutra1BookController {

	@Autowired
	private Sutra1BookService bookService;

	@RequestMapping("/books")
	public List<Sutra1Book> getAll() {
		return bookService.getAllCustom();
	}

	@RequestMapping("/books/{name}")
	public Sutra1Book getByName(@PathVariable String name) {
		Sutra1Book book = bookService.getByName(name);
		System.out.println(book);
		return book;
	}

}
