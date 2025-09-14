package org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.service;

import java.util.List;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.Customer;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.TravelPackage;

public class TravelPackageService {

	public static void add(String name, double price) {
		TransactionManagement.doInTransactionConsumer(session -> {
			TravelPackage travelPackage = new TravelPackage();
			travelPackage.setName(name);
			travelPackage.setPrice(price);
			session.persist(travelPackage);
		});
	}
	
	public static void addToCustomers(int travelPackageId, int customerId) {

		TransactionManagement.doInTransactionConsumer(session -> {
			TravelPackage travelPackage = session.get(TravelPackage.class, travelPackageId);
			Customer customer = session.get(Customer.class, customerId);
			
			customer.addToTravelPackage(travelPackage);
			travelPackage.addToCustomers(customer);
			
			session.merge(travelPackage);
			session.persist(customer);
		});
	}
	
	public static void removeFromCustomers(int travelPackageId, int customerId) {
		TransactionManagement.doInTransactionConsumer(session -> {
			TravelPackage travelPackage = session.get(TravelPackage.class, travelPackageId);
			Customer customer = session.get(Customer.class, customerId);
			
			customer.removeFromTravelPackage(travelPackage);
			travelPackage.removeFromCustomers(customer);
			
			session.merge(travelPackage);
			session.persist(customer);
		});
	}
	
	public static void printAll() {
		TransactionManagement.doInTransactionConsumer(session -> {
			List<TravelPackage> travelPackage = session.createQuery("from TravelPackage", TravelPackage.class).list();
			PrintToScreenHelper.print("TravelPackage: "+ travelPackage);
		});
	}
	
	public static TravelPackage get(int travelPackageId) {
		return TransactionManagement.doInTransactionFunction(session -> session.get(TravelPackage.class, travelPackageId));
	}
	
	public static void delete(int travelPackageId) {
		TransactionManagement.doInTransactionConsumer(session ->{ 
			TravelPackage travelPackage = session.get(TravelPackage.class, travelPackageId);
			session.remove(travelPackage);
		});
	}
	
	
}
