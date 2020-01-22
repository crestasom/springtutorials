package com.crestasom.springbootcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "p_id")
	private int pId;
	@Column(name = "p_name")
	private String pName;
	@Column(name = "p_diagnosis")
	private String pDiagnosis;
	@Column(name = "p_address")
	private String pAddress;
	@ManyToOne
	@JoinColumn(name = "hosp_id")
	private Hospital hospital;
	@ManyToOne
	@JoinColumn(name = "doct_id")
	private Doctor doctor;

	@Transient
	private int hospId;
	@Transient
	private int doctId;

	public Patient() {

	}

	public Patient(int pId, String pName, String pDiagnosis, String pAddress, Hospital hospital, Doctor doctor) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pDiagnosis = pDiagnosis;
		this.pAddress = pAddress;
		this.hospital = hospital;
		this.doctor = doctor;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDiagnosis() {
		return pDiagnosis;
	}

	public void setpDiagnosis(String pDiagnosis) {
		this.pDiagnosis = pDiagnosis;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getHospId() {
		return hospId;
	}

	public void setHospId(int hospId) {
		this.hospId = hospId;
	}

	public int getDoctId() {
		return doctId;
	}

	public void setDoctId(int doctId) {
		this.doctId = doctId;
	}

}
