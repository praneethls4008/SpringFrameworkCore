package org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.service;

import java.util.List;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.Customer;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.TravelPackage;

public class CustomerService {

	public static void add(String name) {
		Customer customer = new Customer();
		customer.setName(name);
		TransactionManagement.doInTransactionConsumer(session -> {
			session.persist(customer);
		});
	}
	
	public static void addToTravelPackages(int customerId, int travelPackageId) {
		
		Customer customer = get(customerId);
		TravelPackage travelPackage = TravelPackageService.get(travelPackageId);
		
		customer.addToTravelPackage(travelPackage);
		
		TransactionManagement.doInTransactionConsumer(session -> {
			session.merge(customer);
		});
	}
	
	public static void removeFromTravelPackages(int customerId, int travelPackageId) {
		
		Customer customer = get(customerId);
		TravelPackage travelPackage = TravelPackageService.get(travelPackageId);
		
		customer.removeFromTravelPackage(travelPackage);
		
		TransactionManagement.doInTransactionConsumer(session -> {
			session.merge(customer);
		});
	}
	
	public static void printAll() {
		PrintToScreenHelper.print("Customer: "+TransactionManagement.doInTransactionFunction(session -> session.createQuery("from Customer", Customer.class).list()));
	}
	
	public static Customer get(int customerId) {
		return TransactionManagement.doInTransactionFunction(session -> session.get(Customer.class, customerId));
	}
	
	public static void delete(int customerId) {
		Customer customer = TransactionManagement.doInTransactionFunction(session -> session.get(Customer.class, customerId));
		TransactionManagement.doInTransactionConsumer(session -> session.remove(customer));
	}
	
	
}
