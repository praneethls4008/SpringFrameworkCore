package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service;

import java.util.Date;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.Address;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.Passport;

public class PassportService {

	public static void add(int passportNo, int age, int year, Address address ) {
		Passport passportObj = new Passport();
		passportObj.setNumber(passportNo);
		passportObj.setAge(age);
		Date date = new Date();
		date.setYear(year);
		date.setMonth(1);
		passportObj.setExpiryDate(date);
		passportObj.setAddress(address);
		TransactionManagement.doInTransactionConsumer(session -> {
			session.persist(passportObj);
			address.addPassport(passportObj);
			session.merge(address);
		});
		
		
	}
	
	public static void printAll() {
		PrintToScreenHelper.print("Passport: "+TransactionManagement.doInTransactionFunction(session -> session.createQuery("from Passport", Passport.class).list()));
	}
	
	public static Passport get(int passportNo) {
		return TransactionManagement.doInTransactionFunction(session -> session.get(Passport.class, passportNo));
	}
	
	public static void delete(int passportNo) {
		Passport passport = TransactionManagement.doInTransactionFunction(session -> session.get(Passport.class, passportNo));
		TransactionManagement.doInTransactionConsumer(session -> session.remove(passport));
		}
	
	
}
