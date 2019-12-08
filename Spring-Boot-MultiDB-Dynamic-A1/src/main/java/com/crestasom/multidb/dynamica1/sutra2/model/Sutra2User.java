package com.crestasom.multidb.dynamica1.sutra2.model;

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
@Table(name = "users")
public class Sutra2User {
	@Id
	@Column(name = "id")
	private int uId;
	@Column(name = "name")
	private String uName;

}
