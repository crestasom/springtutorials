package com.crestasom.multidb.dynamica1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crestasom.multidb.dynamica1.repo.UserRepo;

public class UserService<T, V> {
	@Autowired
	protected UserRepo<T, V> dao;

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
