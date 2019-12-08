package com.crestasom.multidb.dynamica1.sutra2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.multidb.dynamica1.sutra2.model.Sutra2Copy;
import com.crestasom.multidb.dynamica1.sutra2.service.Sutra2CopyService;

@RestController
@RequestMapping("/sutra2")
public class Sutra2CopyController {

	@Autowired
	private Sutra2CopyService copyService;

	@RequestMapping("/copies")
	public List<Sutra2Copy> getAll() {
		return copyService.getAll();
	}

	@RequestMapping("/copies/book/{id}")
	public List<Sutra2Copy> getAllByBookId(@PathVariable int id) {
		System.out.println("here");
		return copyService.findAllByBookId(id);
	}
}
