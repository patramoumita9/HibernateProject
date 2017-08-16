package com.own.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BasicOperations {

	public static void main(String[] args) {
		Customer customer = new Customer(); // new operator starts a transient session
		customer.setCustomerName("Deepanwita");
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Before the object is associated with session, the state is known as transient
		
		//For adding a row
		session.save(customer); //Persistence state starts while the object is associated with session is called
		
		//For updating details of a particular row
		customer = (Customer) session.get(Customer.class, 20);
//		customer.setCustomerName("Moumita");
//		session.update(customer);
		
		//For deleting a record
//		session.delete(customer); //If we delete any persistent object, the object state will change from persistence to transient
		
		customer.setCustomerName("Moumita after save session");//no save() or update() method is called
		//still it inserts a row in database because of persistence state(To sync up the modification the record present in database, 
		//hibernate fires an update query automatically)
		
		session.getTransaction().commit();
		session.close();  //After closing the session, detach session is started
		customer.setCustomerName("Moumita after close session"); // This record will not be inserted as is called after closing the session
		//i.e. now the customer object is in detach session
		
		//To change the detach state to persistense state, we need to create a new session
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session2.update(customer);
		session2.getTransaction().commit();
		session2.close();
		
	}

}
