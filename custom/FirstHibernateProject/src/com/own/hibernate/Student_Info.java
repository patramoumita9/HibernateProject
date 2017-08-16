package com.own.hibernate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//OneToOne Mapping
@Entity
@Table(name="STUDENT_INFORMATION")
public class Student_Info {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int rollNo;
	
	//@Transient
	@Column(name="STUDENT_NAME", nullable=false)
	private String studentName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rollNo")
	private StudentDetails studentDetails;
	
	public StudentDetails getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
//	@Temporal(TemporalType.DATE)
	//	private Date birthDate;
	//	public Date getBirthDate() {
	//		return birthDate;
	//	}
	//	public void setBirthDate(Date birthDate) {
	//		this.birthDate = birthDate;
	//	}
}
