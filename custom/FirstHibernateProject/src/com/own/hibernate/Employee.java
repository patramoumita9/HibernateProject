package com.own.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//ManyToMany Mapping
@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	@Id @GeneratedValue
	private int empID;
		
	private String empName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<EmployeeCertification> empCertificates = new HashSet<>(0);

	public Set<EmployeeCertification> getEmpCertificates() {
		return empCertificates;
	}

	public void setEmpCertificates(Set<EmployeeCertification> empCertificates) {
		this.empCertificates = empCertificates;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}	
}
