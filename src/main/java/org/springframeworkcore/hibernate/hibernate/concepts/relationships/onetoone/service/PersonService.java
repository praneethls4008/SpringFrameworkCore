package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service;

import java.util.Date;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.PassportForPerson;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.Person;

public class PersonService {
	public static void add(String name, PassportForPerson passport ) {
		Person personObj = new Person();
		personObj.setName(name);
		personObj.setPassport(passport);
		TransactionManagement.doInTransactionConsumer(session -> session.persist(personObj));
	}
	
	public static void printAll() {
		
		PrintToScreenHelper.print("Person: "+TransactionManagement.doInTransactionFunction(session -> session.createQuery("from Person", Person.class).list()));
	}
	
	public static void delete(int personId) {
		Person person = TransactionManagement.doInTransactionFunction(session -> session.get(Person.class, personId));
		TransactionManagement.doInTransactionConsumer(session -> session.remove(person));
		}
}
