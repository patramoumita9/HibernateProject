package com.own.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import org.hibernate.annotations.Parameter;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//OneToOne Mapping
@Entity
@Table(name="STUDENT_DETAILS")
public class StudentDetails {
	@Id @GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator", strategy="foreign", parameters={ @Parameter(value="studentInfo", name="property") })
	private int rollNo;
	
	private String stuMobileNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rollNo")
	private Student_Info studentInfo;
	
	public Student_Info getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(Student_Info studentInfo) {
		this.studentInfo = studentInfo;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStuMobileNo() {
		return stuMobileNo;
	}
	public void setStuMobileNo(String stuMobileNo) {
		this.stuMobileNo = stuMobileNo;
	}
}
