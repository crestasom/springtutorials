package com.crestasom.multidb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.multidb.book.model.Copy;
import com.crestasom.multidb.book.repo.CopyRepo;

@Service
public class CopyService {

	@Autowired
	private CopyRepo copyRepo;

	public List<Copy> getAllCopies() {
		List<Copy> cList = new ArrayList<>();
		copyRepo.findAll().forEach(b -> cList.add(b));
		return cList;
	}

}
