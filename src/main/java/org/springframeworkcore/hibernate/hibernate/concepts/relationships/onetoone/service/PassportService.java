package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service;

import java.util.Date;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.PassportForPerson;

public class PassportService {

	public static void add(int passportNo, int age, int year) {
		TransactionManagement.doInTransactionConsumer(session -> {
			PassportForPerson passportObj = new PassportForPerson();
			passportObj.setNumber(passportNo);
			passportObj.setAge(age);
			Date date = new Date();
			date.setYear(year);
			date.setMonth(1);
			passportObj.setExpiryDate(date);
			session.persist(passportObj);
		});
		
		
	}
	
	public static void printAll() {
		TransactionManagement.doInTransactionConsumer(session -> {
			PrintToScreenHelper.print("Passport: "+ session.createQuery("from PassportForPerson", PassportForPerson.class).list());
		});
	}
	
	public static PassportForPerson get(int passportNo) {
		return TransactionManagement.doInTransactionFunction(session -> session.get(PassportForPerson.class, passportNo));
	}
	
	public static void delete(int passportNo) {
		TransactionManagement.doInTransactionConsumer(session -> {
			PassportForPerson passport = session.get(PassportForPerson.class, passportNo);
			session.remove(passport);
		});
		}
	
	
}
