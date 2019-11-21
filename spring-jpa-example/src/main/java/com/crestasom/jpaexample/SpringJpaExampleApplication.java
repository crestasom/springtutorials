package com.crestasom.jpaexample;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crestasom.jpaexample.entity.Department;
import com.crestasom.jpaexample.entity.Person;
import com.crestasom.jpaexample.service.DepartmentService;
import com.crestasom.jpaexample.service.PersonService;
import com.crestasom.jpaexample.test.AccountEntity;
import com.crestasom.jpaexample.test.EmployeeDao;
import com.crestasom.jpaexample.test.EmployeeEntity;

@SpringBootApplication
public class SpringJpaExampleApplication{

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PersonService personService;
	@Autowired
	private EmployeeDao employeeDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaExampleApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception { createAccount();
	 * createDepartment(); createPerson(); Set<Department> dSet =
	 * departmentService.getAllDepList(); for (Department d : dSet) {
	 * System.out.println(d); } }
	 */

	public void createPerson() {
		Person p1 = new Person("ranchor", "chanchar", "ranchorchanchar@mail.com", new Date());
		Department d = departmentService.getDepartment(2);
		p1.setDepartment(d);
		personService.addPerson(p1);

	}

	public void createDepartment() {

		Person p1 = new Person("raju", "rastogi", "rajurastogi@mail.com", new Date());
		Person p2 = new Person("faran", "khuresi", "farankhuresi@mail.com", new Date());
		Set<Person> perSet = new HashSet<>();
		perSet.add(p1);
		perSet.add(p2);

		Department d = new Department();
		d.setName("Civil");
		d.setCreationDate(new Date());
		d.setDeptHead(perSet);
		departmentService.addDepartment(d);

		Person p3 = new Person("chatur", "ramalingan", "chaturramalingan@mail.com", new Date());
		Department d2 = new Department();
		d2.setName("Computer");
		d2.setCreationDate(new Date());
		Set<Person> perSet2 = new HashSet<>();
		perSet2.add(p3);
		d2.setDeptHead(perSet2);

		departmentService.addDepartment(d2);
	}

	public void createAccount() {
		AccountEntity account1 = new AccountEntity();
		account1.setAccountNumber("Account detail 1");

		AccountEntity account2 = new AccountEntity();
		account2.setAccountNumber("Account detail 2");

		AccountEntity account3 = new AccountEntity();
		account3.setAccountNumber("Account detail 3");

		// Add new Employee object
		EmployeeEntity firstEmployee = new EmployeeEntity();
		firstEmployee.setEmail("demo-user-first@mail.com");
		firstEmployee.setFirstName("demo-one");
		firstEmployee.setLastName("user-one");

		EmployeeEntity secondEmployee = new EmployeeEntity();
		secondEmployee.setEmail("demo-user-second@mail.com");
		secondEmployee.setFirstName("demo-two");
		secondEmployee.setLastName("user-two");

		Set<AccountEntity> accountsOfFirstEmployee = new HashSet<AccountEntity>();
		accountsOfFirstEmployee.add(account1);
		accountsOfFirstEmployee.add(account2);

		Set<AccountEntity> accountsOfSecondEmployee = new HashSet<AccountEntity>();
		accountsOfSecondEmployee.add(account3);

		firstEmployee.setAccounts(accountsOfFirstEmployee);
		secondEmployee.setAccounts(accountsOfSecondEmployee);
		employeeDao.save(firstEmployee);
		employeeDao.save(secondEmployee);
	}
}
