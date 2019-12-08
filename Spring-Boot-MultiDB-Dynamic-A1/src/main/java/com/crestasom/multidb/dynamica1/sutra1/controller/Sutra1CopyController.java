package com.crestasom.multidb.dynamica1.sutra1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.multidb.dynamica1.sutra1.model.Sutra1Copy;
import com.crestasom.multidb.dynamica1.sutra1.service.Sutra1CopyService;

@RestController
@RequestMapping("/sutra1")
public class Sutra1CopyController {

	@Autowired
	private Sutra1CopyService copyService;

	@RequestMapping("/copies")
	public List<Sutra1Copy> getAll() {
		return copyService.getAll();
	}

	@RequestMapping("/copies/book/{id}")
	public List<Sutra1Copy> getAllByBookId(@PathVariable int id) {
		System.out.println("here");
		return copyService.findAllByBookId(id);
	}

}
