package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.entity.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDAO personDAO;

	List<Person> personList;

	public PersonService() {
		super();

		this.personList = new ArrayList<Person>();
		personList.add(new Person(0, "Ram", "ram@gmail.com"));
		personList.add(new Person(1, "Sam", "sam@gmail.com"));
		personList.add(new Person(2, "Hari", "hari@gmail.com"));
		personList.add(new Person(3, "Sita", "sita@gmail.com"));
		personList.add(new Person(4, "Gita", "gita@gmail.com"));

	}

	public List<Person> getAllPerson() {
		List<Person> pList = new ArrayList<>();
		personDAO.personList().forEach(pList::add);
		return pList;
	}

	public void addPerson(Person p) {
		personDAO.save(p);
	}

	public void deletePerson(int id) {
		personDAO.deleteById(id);
	}

	public Person getPerson(int id) {
		return personDAO.getPerson(id).get();
	}

	public void updatePerson(Person p) {
		personDAO.save(p);
		// personList.get(p.getId()).setName(p.getName());
		// personList.get(p.getId()).setEmail(p.getEmail());
	}

}
