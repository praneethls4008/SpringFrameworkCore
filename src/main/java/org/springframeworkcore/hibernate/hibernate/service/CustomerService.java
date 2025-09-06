package org.springframeworkcore.hibernate.hibernate.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframeworkcore.hibernate.hibernate.dto.CustomerDTO;
import org.springframeworkcore.hibernate.hibernate.entities.Customer;
import org.springframeworkcore.hibernate.hibernate.utils.SessionFactoryUtil;

public class CustomerService {
	private CustomerDTO customerDTO;

	public CustomerService(){
		customerDTO = new CustomerDTO();
	}
	
	public Customer get(int customerID) {
		return customerDTO.get(customerID);
	}
	
	public List<Customer> getAll() {
		return customerDTO.getAll();
	}
	
	public void delete(int customerID) {
		customerDTO.delete(customerID);
	}

	public void save(Customer customer) {
		customerDTO.save(customer);
	}
	
	public void update(Customer customer) {
		customerDTO.update(customer);
	}
	
}
