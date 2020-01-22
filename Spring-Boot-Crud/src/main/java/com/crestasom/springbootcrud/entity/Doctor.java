package com.crestasom.springbootcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "doctor")
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "d_id")
	private int dId;
	@Column(name = "d_name")
	private String dName;
	@Column(name = "d_qualification")
	private String dQualification;
	@Column(name = "d_salary")
	private double dSalary;
	@ManyToOne
	@JoinColumn(name = "h_id")
	private Hospital workHosp;

	@Transient
	private int hostId;

	public Doctor() {

	}

	public Doctor(int dId, String dName, String dQualification, double dSalary, Hospital workHosp) {
		this.dId = dId;
		this.dName = dName;
		this.dQualification = dQualification;
		this.dSalary = dSalary;
		this.workHosp = workHosp;
	}

	
	
	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hosId) {
		this.hostId = hosId;
	}

	public Hospital getWorkHosp() {
		return workHosp;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdQualification() {
		return dQualification;
	}

	public void setdQualification(String dQualification) {
		this.dQualification = dQualification;
	}

	public double getdSalary() {
		return dSalary;
	}

	public void setdSalary(double dSalary) {
		this.dSalary = dSalary;
	}

	public void setWorkHosp(Hospital workHosp) {
		this.workHosp = workHosp;
	}

	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", dName=" + dName + ", dQualification=" + dQualification + ", dSalary=" + dSalary
				+ ", workHosp=" + workHosp.gethName() + "]";
	}

}
