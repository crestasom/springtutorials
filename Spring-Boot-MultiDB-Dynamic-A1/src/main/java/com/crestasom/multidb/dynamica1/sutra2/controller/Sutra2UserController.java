package com.crestasom.multidb.dynamica1.sutra2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.multidb.dynamica1.model.Book;
import com.crestasom.multidb.dynamica1.sutra1.model.Sutra1Book;
import com.crestasom.multidb.dynamica1.sutra1.model.Sutra1User;
import com.crestasom.multidb.dynamica1.sutra1.service.Sutra1BookService;
import com.crestasom.multidb.dynamica1.sutra1.service.Sutra1UserService;
import com.crestasom.multidb.dynamica1.sutra2.model.Sutra2User;
import com.crestasom.multidb.dynamica1.sutra2.service.Sutra2UserService;

@RestController
@RequestMapping("/sutra2")
public class Sutra2UserController {

	@Autowired
	private Sutra2UserService userService;

	@RequestMapping("/users")
	public List<Sutra2User> getAll() {
		return userService.getAll();
	}
	

}
