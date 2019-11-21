package com.crestasom.springmvctutorial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crestasom.springmvctutorial.entity.Person;

@Service
public class PersonService {

	private List<Person> plist;

	public PersonService() {
		plist = new ArrayList<Person>();
		plist.add(new Person(1, "ram", "ram@gmail.com"));
		plist.add(new Person(1, "hari", "hari@gmail.com"));
		plist.add(new Person(1, "sita", "sita@gmail.com"));
	}

	public List<Person> getAllPerson() {
		return plist;
	}

	public void addPerson(Person p) {
		plist.add(p);
	}
}
