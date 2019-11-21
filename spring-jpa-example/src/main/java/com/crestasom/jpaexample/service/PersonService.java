package com.crestasom.jpaexample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.jpaexample.dao.PersonDao;
import com.crestasom.jpaexample.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public List<Person> getAllPerson() {
		List<Person> pList = new ArrayList<>();
		personDao.findAll().forEach(pList::add);
		return pList;

	}

	public void addPerson(Person p) {
		personDao.save(p);
	}

	public void deletePerson(int id) {
		System.out.println("I am here in person service");
		personDao.deleteById(id);
	}

	public Person getPerson(int id) {
		return personDao.findById(id).get();
	}

	public void updatePerson(Person p) {

	}
}
