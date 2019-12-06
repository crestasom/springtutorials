package com.crestasom.multidb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.multidb.user.model.User;
import com.crestasom.multidb.user.repo.UserBeanRepo;

@Service
public class UserService {

	@Autowired
	private UserBeanRepo userRepo;

	public List<User> getAllUsers() {
		List<User> uList = new ArrayList<User>();
		userRepo.findAll().forEach(b -> uList.add(b));
		return uList;
	}

}
