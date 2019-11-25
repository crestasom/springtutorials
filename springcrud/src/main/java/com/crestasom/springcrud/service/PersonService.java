package com.crestasom.springcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crestasom.springcrud.entity.Person;

@Component
public class PersonService {

	List<Person> personList;

	public PersonService() {
		super();
		this.personList = new ArrayList<Person>();
		personList.add(new Person(0, "Ram", "ram@mail.com"));
		personList.add(new Person(1, "Sam", "sam@mail.com"));
		personList.add(new Person(2, "Hari", "hari@mail.com"));
		personList.add(new Person(3, "Sita", "sita@mail.com"));
		personList.add(new Person(4, "Gita", "gita@mail.com"));
	}

	public List<Person> getAllPerson() {
		return personList;
	}

	public void addPerson(Person p) {
		personList.add(p);
	}

	public void deletePerson(int id) {
		personList.remove(id);
	}

	public Person getPerson(int id) {
		return personList.get(id);
	}

	public void updatePerson(Person p) {
		personList.get(p.getId()).setName(p.getName());
		personList.get(p.getId()).setEmail(p.getEmail());
	}

}
