package org.springframeworkcore.hibernate.hibernate.concepts.embedable;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.entities.Customer;

public class Run {
	
	public static void main(String[] args) {
		
		
		
		TransactionManagement.doInTransactionConsumer(session -> {
			ClassA a = new ClassA();
			ClassB b = new ClassB();
			b.setCourseName("course1");
			a.setName("name1");
			a.setClassB(b);
			session.persist(a);
			});
		System.out.println(TransactionManagement.doInTransactionFunction(session -> session.createQuery("from ClassA", ClassA.class).list()));
	}
}
