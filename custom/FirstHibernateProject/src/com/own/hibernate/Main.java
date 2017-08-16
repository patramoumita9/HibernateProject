package com.own.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
		
		//Example of OneToOne mapping
		Student_Info student = new Student_Info();
		student.setStudentName("Mou");
		//	student.setRollNo(1);
		//student.setBirthDate(new Date());
		
		Student_Info student1 = new Student_Info();
		student1.setStudentName("Moumita");
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setStuMobileNo("833XX12XX7");
		studentDetails.setStudentInfo(student);
		
		StudentDetails studentDetails1 = new StudentDetails();
		studentDetails1.setStuMobileNo("891XX39XX0");
		studentDetails1.setStudentInfo(student1);
		
		//For bi-directional mapping
		student.setStudentDetails(studentDetails);
		student1.setStudentDetails(studentDetails1);
		
		//Example of ManyToOne mapping
		Address address = new Address();
		address.setAddressDetails("Naskarpur, Howrah");
		
		Student std = new Student();
		std.setStuName("Soumyajit");
		
		Student std1 = new Student();
		std1.setStuName("Soumyajit Ray");
		
		Address address1 = new Address();
		address1.setAddressDetails("Newtown, Kolkata");
		
		Student std2 = new Student();
		std2.setStuName("Soumyo");
		
		Student std3 = new Student();
		std3.setStuName("Somu");
		
		std.setAddress(address);
		std1.setAddress(address);
		
		std2.setAddress(address1);
		std3.setAddress(address1);
		
		//For bi-directional mapping
		(address1.getStudents()).add(std2);
		(address1.getStudents()).add(std3);
		
		//Example of ManyToOne mapping
		Employee emp = new Employee();
		emp.setEmpName("Tuli");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("Tulika");
		
		EmployeeCertification empCert = new EmployeeCertification();
		empCert.setCertificationDetails("Java SE 8 Programmer I");
		
		EmployeeCertification empCert1 = new EmployeeCertification();
		empCert1.setCertificationDetails("Java SE 8 Programmer II");
		
		Employee emp2 = new Employee();
		emp2.setEmpName("Tuli Patra");
		
		Employee emp3 = new Employee();
		emp3.setEmpName("Tulika Patra");
		
		EmployeeCertification empCert2 = new EmployeeCertification();
		empCert2.setCertificationDetails("Oracle DB Certification Exam");
		
		EmployeeCertification empCert3 = new EmployeeCertification();
		empCert3.setCertificationDetails("Oracle DB Certification Exam");
		
		(emp.getEmpCertificates()).add(empCert);
		(emp1.getEmpCertificates()).add(empCert1);
		
		//For bi-directional mapping
		(empCert2.getEmployees()).add(emp2);
		(empCert3.getEmployees()).add(emp3);
		
		Configuration configuration = new Configuration();
		
		//SessionFactory contains all the data regarding hibernate configuration file
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		
		//When a session is opened, a database connection will be opened internally
		Session session = sessionFactory.openSession();
		
		//For create/delete/update operation, hibernate needs a logical transaction
		//For select(read) operation, transaction is not required
		session.beginTransaction();
		
		//For OneToOne uni-directional mapping
		session.save(studentDetails);
		//For OneToOne bi-directional mapping
		session.save(student1);
		
		//For ManyToOne uni-directional mapping
		session.save(std);
		session.save(std1);
		
		//For ManyToOne bi-directional mapping or OneToMany mapping
		session.save(address1);
		
		//For ManyToMany uni-directional mapping
		session.save(emp);
		session.save(emp1);
		
		//For ManyToMany bi-directional mapping
		session.save(empCert2);
		session.save(empCert3);
		
		session.getTransaction().commit();
		session.close();
		//sessionFactory.close();
	}

}
