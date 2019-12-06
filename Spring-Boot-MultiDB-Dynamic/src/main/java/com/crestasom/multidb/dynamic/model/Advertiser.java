package com.crestasom.multidb.dynamic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advertiser {
	@Id
	@Column(name = "ID")
	int id;
	@Column(name = "NAME")
	int name;
}
