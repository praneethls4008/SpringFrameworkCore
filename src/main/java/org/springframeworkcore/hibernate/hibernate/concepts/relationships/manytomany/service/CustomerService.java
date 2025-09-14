package org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.service;

import java.util.List;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.Customer;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.TravelPackage;

public class CustomerService {

	public static void add(String name) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Customer customer = new Customer();
			customer.setName(name);
			session.persist(customer);
		});
	}
	
	public static void addToTravelPackages(int customerId, int travelPackageId) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Customer customer = session.get(Customer.class, customerId);
			TravelPackage travelPackage = session.get(TravelPackage.class, travelPackageId);
			
			travelPackage.addToCustomers(customer);
			customer.addToTravelPackage(travelPackage);
			
			session.merge(customer);
			session.merge(travelPackage);
		});
	}
	
	public static void removeFromTravelPackages(int customerId, int travelPackageId) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Customer customer = session.get(Customer.class, customerId);
			TravelPackage travelPackage = session.get(TravelPackage.class, travelPackageId);
			
			travelPackage.removeFromCustomers(customer);
			customer.removeFromTravelPackage(travelPackage);
			
			session.merge(customer);
			session.merge(travelPackage);
		});
	}
	
	public static void printAll() {
		TransactionManagement.doInTransactionConsumer(session -> {
			List<Customer> customer = session.createQuery("from Customer", Customer.class).list();
			PrintToScreenHelper.print("Customer: "+ customer);
		});
	}
	
	public static Customer get(int customerId) {
		return TransactionManagement.doInTransactionFunction(session -> session.get(Customer.class, customerId));
	}
	
	public static void delete(int customerId) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Customer customer = session.get(Customer.class, customerId);
			session.remove(customer);
		});
	}
	
	
}
