package com.crestasom.jpaexample.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.jpaexample.dao.DepartmentDao;
import com.crestasom.jpaexample.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	public Set<Department> getAllDepList() {
		Set<Department> dList = new HashSet<>();
		departmentDao.findAll().forEach(dList::add);
		return dList;
	}

	public void addDepartment(Department d) {
		departmentDao.save(d);
	}

	public void deleteDepartment(int id) {
		departmentDao.deleteById(id);
	}

	public Department getDepartment(int id) {
		return departmentDao.findById(id).get();
	}

}
