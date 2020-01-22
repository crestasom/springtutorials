package com.crestasom.springbootcrud.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "hospital")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "h_id")
	private int hosId;
	@NotEmpty(message = "Name should not be empty")
	@Column(name = "h_name")
	private String hName;
	@Pattern(regexp = "[^0-9]*", message = "Address should not contain any digit")
	@Column(name = "h_address")
	private String hAddress;
	@Column(name = "h_city")
	private String hCity;

	@Column
	private boolean active = true;

	public Hospital(String hName, String hAddress, String hCity) {
		super();
		this.hName = hName;
		this.hAddress = hAddress;
		this.hCity = hCity;
	}

	public Hospital(int hId, String hName, String hAddress, String hCity) {
		super();
		this.hosId = hId;
		this.hName = hName;
		this.hAddress = hAddress;
		this.hCity = hCity;
	}

	public Hospital() {

	}

	public int getHosId() {
		return hosId;
	}

	public void setHosId(int hosId) {
		this.hosId = hosId;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public String gethAddress() {
		return hAddress;
	}

	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}

	public String gethCity() {
		return hCity;
	}

	public void sethCity(String hCity) {
		this.hCity = hCity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
