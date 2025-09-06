package org.springframeworkcore.hibernate.hibernate;

import org.springframeworkcore.hibernate.hibernate.entities.Customer;
import org.springframeworkcore.hibernate.hibernate.service.CustomerService;
import org.springframeworkcore.hibernate.hibernate.utils.SessionFactoryUtil;

public class RunApp {
	
	public static void main(String[] args) {
		CustomerService cService = new CustomerService();
		try {
			Customer customer = new Customer();
			customer.setName("sachin5");
			customer.setEmail("sachin@email.com");
			
			Customer updateCustomer = new Customer();
			updateCustomer.setId(552);
			updateCustomer.setName("bhoni");
			
	//		System.out.println(cService.getAll());
//			cService.save(customer);
			cService.update(updateCustomer);
			
	//		cService.delete(102);
			System.out.println(cService.getAll());
		}
		catch(Exception e){
			e.printStackTrace();
			SessionFactoryUtil.shutDownSessionFactory();
		}
	}
}
