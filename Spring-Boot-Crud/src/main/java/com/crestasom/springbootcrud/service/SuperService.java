package com.crestasom.springbootcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class SuperService<T, V> {

	
	
	@Autowired
	protected CrudRepository<T, V> dao;
	
	public List<T> getAll() {
		List<T> lists = new ArrayList<>();
		dao.findAll().forEach(a -> lists.add(a));
		return lists;

	}

	public void add(T t) {
		dao.save(t);
	}

	public void deleteById(V id) {
		dao.deleteById(id);
	}

	public T get(V id) {
		return dao.findById(id).get();
	}

}
