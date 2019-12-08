package com.crestasom.multidb.dynamica1.sutra1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Book")
public class Sutra1Book {

	@Id
	@Column(name = "bId")
	private int id;
	@Column(name = "bName")
	private String name;

}
