package org.springframeworkcore.hibernate.hibernate.dto;

import java.util.List;

import org.springframeworkcore.hibernate.hibernate.entities.Customer;
import org.springframeworkcore.hibernate.hibernate.utils.TransactionManagement;

public class CustomerDTO {

	public void save(Customer customer){
		TransactionManagement.doInTransactionConsumer(session-> 
		{
			session.persist(customer);
		});
	}
	
	public void update(Customer newCustomer) {
		TransactionManagement.doInTransactionConsumer(session -> {
			
			if(newCustomer.getId()<=0) {
				throw new IllegalArgumentException("Customer Id is not present to update");
			}
			
			Customer oldCustomer = session.get(Customer.class, newCustomer.getId());
			
			if(oldCustomer==null) {
				throw new IllegalArgumentException("No customer present with customer id "+ newCustomer.getId());
			}
			
			if(newCustomer.getName()==null) {
				newCustomer.setName(oldCustomer.getName());
			}
			
			if(newCustomer.getEmail()==null) {
				newCustomer.setEmail(oldCustomer.getEmail());
			}
			session.merge(newCustomer);
		});
	}
	
	public Customer get(int customerId) {
		return TransactionManagement.doInTransactionFunction(session -> session.get(Customer.class, customerId));
	}
	
	public List<Customer> getAll() {
		return TransactionManagement.doInTransactionFunction(session -> session.createQuery("from Customer", Customer.class).list());
	}
	
	public void delete(int customerId) {
		TransactionManagement.doInTransactionConsumer(session -> {
			Customer customer = session.get(Customer.class, customerId);
			session.remove(customer);
		});
	}
	

}
