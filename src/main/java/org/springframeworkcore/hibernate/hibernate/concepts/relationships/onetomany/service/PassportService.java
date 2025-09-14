package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.service;

import java.util.Date;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.Address;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.Passport;

public class PassportService {

	public static void add(int passportNo, int age, int year, Address address ) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Passport passportObj = new Passport();
			passportObj.setNumber(passportNo);
			passportObj.setAge(age);
			Date date = new Date();
			date.setYear(year);
			date.setMonth(1);
			passportObj.setExpiryDate(date);
			passportObj.setAddress(address);
			session.persist(passportObj);
			address.addPassport(passportObj);
			session.merge(address);
		});
		
		
	}
	
	public static void printAll() {
		TransactionManagement.doInTransactionConsumer(session -> {
			PrintToScreenHelper.print("Passport: "+ session.createQuery("from Passport", Passport.class).list());
		});
	}
	
	public static Passport get(int passportNo) {
		return TransactionManagement.doInTransactionFunction(session -> session.get(Passport.class, passportNo));
	}
	
	public static void delete(int passportNo) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Passport passport = session.get(Passport.class, passportNo);
			session.remove(passport);
		});
		}
	
	
}
