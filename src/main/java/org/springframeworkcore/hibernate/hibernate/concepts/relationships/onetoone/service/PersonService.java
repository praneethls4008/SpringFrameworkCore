package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service;

import java.util.Date;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.PassportForPerson;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.Person;

public class PersonService {
	public static void add(String name, PassportForPerson passport ) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Person personObj = new Person();
			personObj.setName(name);
			personObj.setPassport(passport);
			session.persist(personObj);
			});
	}
	
	public static void printAll() {
		
		TransactionManagement.doInTransactionConsumer(session -> {
			PrintToScreenHelper.print("Person: "+ session.createQuery("from Person", Person.class).list());
		});
	}
	
	public static void delete(int personId) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Person person = session.get(Person.class, personId);
			session.remove(person);
			});
		}
}
