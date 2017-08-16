package com.own.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//ManyToMany Mapping
@Entity
@Table(name="EMPLOYEE_CERTIFICATION")
public class EmployeeCertification {
	
	@Id @GeneratedValue
	private int certificateID;
		
	private String certificationDetails;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public int getCertificateID() {
		return certificateID;
	}

	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}

	public String getCertificationDetails() {
		return certificationDetails;
	}

	public void setCertificationDetails(String certificationDetails) {
		this.certificationDetails = certificationDetails;
	}
}
