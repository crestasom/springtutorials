package com.crestasom.jpaexample.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department_table")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private int id;
	@Column(name = "name")
	private String name;
	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinColumn(name = "department_department_id")

	private Set<Person> deptHead;
	@Column(name = "creation_date")
	private Date creationDate;

	public Department() {

	}

	public Department(String name, Set<Person> deptHead, Date creationDate) {
		super();
		this.name = name;
		this.deptHead = deptHead;
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(Set<Person> deptHead) {
		this.deptHead = deptHead;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", deptHead=" + deptHead + ", creationDate=" + creationDate
				+ "]";
	}

}
