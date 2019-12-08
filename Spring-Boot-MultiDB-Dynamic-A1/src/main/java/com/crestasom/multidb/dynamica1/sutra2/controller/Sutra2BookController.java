package com.crestasom.multidb.dynamica1.sutra2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.multidb.dynamica1.model.Book;
import com.crestasom.multidb.dynamica1.sutra2.model.Sutra2Book;
import com.crestasom.multidb.dynamica1.sutra2.model.Sutra2User;
import com.crestasom.multidb.dynamica1.sutra2.service.Sutra2BookService;
import com.crestasom.multidb.dynamica1.sutra2.service.Sutra2UserService;

@RestController
@RequestMapping("/sutra2")
public class Sutra2BookController {

	@Autowired
	private Sutra2BookService bookService;

	@Autowired
	private Sutra2UserService userService;

	@RequestMapping("/books")
	public List<Sutra2Book> getAllBooks() {
		return bookService.getAll();
	}

}
