package org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.service;

import java.util.List;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.Customer;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.TravelPackage;

public class TravelPackageService {

	public static void add(String name, double price) {
		TravelPackage travelPackage = new TravelPackage();
		travelPackage.setName(name);
		travelPackage.setPrice(price);
		TransactionManagement.doInTransactionConsumer(session -> {
			session.persist(travelPackage);
		});
	}
	
	public static void addToCustomers(int travelPackageId, Customer customer) {
		
		TravelPackage travelPackage = get(travelPackageId);
		travelPackage.addToCustomers(customer);
		
		TransactionManagement.doInTransactionConsumer(session -> {
			session.merge(travelPackage);
		});
	}
	
	public static void removeFromCustomers(int travelPackageId, Customer customer) {
		
		TravelPackage travelPackage = get(travelPackageId);
		travelPackage.removeFromCustomers(customer);
		
		TransactionManagement.doInTransactionConsumer(session -> {
			session.merge(travelPackage);
		});
	}
	
	public static void printAll() {
		PrintToScreenHelper.print("TravelPackage: "+TransactionManagement.doInTransactionFunction(session -> session.createQuery("from TravelPackage", TravelPackage.class).list()));
	}
	
	public static TravelPackage get(int travelPackageId) {
		return TransactionManagement.doInTransactionFunction(session -> session.get(TravelPackage.class, travelPackageId));
	}
	
	public static void delete(int travelPackageId) {
		TravelPackage travelPackage = TransactionManagement.doInTransactionFunction(session -> session.get(TravelPackage.class, travelPackageId));
		TransactionManagement.doInTransactionConsumer(session -> session.remove(travelPackage));
	}
	
	
}
