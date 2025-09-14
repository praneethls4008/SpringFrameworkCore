package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.service;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.Address;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.Passport;

public class AddressService {

	public static void add(String country, String state, int zip) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Address address = new Address();
			address.setCountry(country);
			address.setState(state);
			address.setZip(zip);
			session.persist(address);
		});
	}
	
	public static void delete(int zip) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Address address = session.get(Address.class, zip);
			session.remove(address);
		});
	}
	
	public static Address get(int zip) {
		return TransactionManagement.doInTransactionFunction(session -> session.get(Address.class, zip));
	}
	
	public static void printAll() {
		TransactionManagement.doInTransactionConsumer(session -> {
			PrintToScreenHelper.print("Address: "+ session.createQuery("from Address", Address.class).list());
		});
	}
	
	public static void deletePassportFromList(int zip,  int passportNo) {
		
		TransactionManagement.doInTransactionConsumer(session -> {
			Address address = session.get(Address.class, zip);
			Passport passport = session.get(Passport.class, passportNo);
			address.deletePassport(passport);
//			passport.setAddress(null);
//			session.merge(passport);
//			session.remove(passport);
			session.merge(address);
		});
		}
	
	
	
}
