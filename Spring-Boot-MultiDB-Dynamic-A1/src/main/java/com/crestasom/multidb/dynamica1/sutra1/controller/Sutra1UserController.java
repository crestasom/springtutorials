package com.crestasom.multidb.dynamica1.sutra1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.multidb.dynamica1.model.Book;
import com.crestasom.multidb.dynamica1.sutra1.model.Sutra1Book;
import com.crestasom.multidb.dynamica1.sutra1.model.Sutra1User;
import com.crestasom.multidb.dynamica1.sutra1.service.Sutra1BookService;
import com.crestasom.multidb.dynamica1.sutra1.service.Sutra1UserService;

@RestController
@RequestMapping("/sutra1")
public class Sutra1UserController {

	@Autowired
	private Sutra1UserService userService;

	@RequestMapping("/users")
	public List<Sutra1User> getAll() {
		return userService.getAll();
	}

}
