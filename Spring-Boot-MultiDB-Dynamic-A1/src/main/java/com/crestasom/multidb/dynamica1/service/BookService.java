package com.crestasom.multidb.dynamica1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.crestasom.multidb.dynamica1.repo.BookRepo;

public class BookService<T, V> {

	@Autowired
	protected BookRepo<T, V> dao;
	
	

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

	public T getByName(String name) {
		return dao.findByName(name).isPresent() ? dao.findByName(name).get() : null;
	}

	public List<T> getAllCustom() {
		return dao.getAllBook();
	}

}
