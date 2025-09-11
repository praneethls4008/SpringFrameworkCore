package org.springframeworkcore.hibernate.hibernate;

import java.io.FileInputStream;
import java.util.Date;

import org.springframeworkcore.hibernate.hibernate.entities.Customer;
import org.springframeworkcore.hibernate.hibernate.service.CustomerService;
import org.springframeworkcore.hibernate.hibernate.utils.SessionFactoryUtil;
import org.springframeworkcore.hibernate.hibernate.utils.TransactionManagement;

public class RunApp {
	
	public static void main(String[] args) {
		CustomerService cService = new CustomerService();
		try {
			
			FileInputStream fis = new FileInputStream("src/main/resources/images/Screenshot 2025-07-26 194931.png");
			byte[] imageBytes = new byte[fis.available()];
			fis.read(imageBytes);
			
			Customer customer = new Customer();
			customer.setName("new customer2");
			customer.setEmail("newCustomer2@email.com");
			customer.setDate(new Date());
			customer.setProfilePicture(imageBytes);
			Customer updateCustomer = new Customer();
			updateCustomer.setId(552);
			updateCustomer.setName("bhoni");
			
	//		System.out.println(cService.getAll());
//			cService.save(customer);
//			cService.update(updateCustomer);
			
	//		cService.delete(102);
			
			Customer c1 = TransactionManagement.doInTransactionFunction(session -> session.load(Customer.class, 2));
			
//			Customer c1 = cService.get(2);
			System.out.println(c1);
			Customer c2 = cService.get(2);
			System.out.println(c2);
//			System.out.println(cService.getAll());
		}
		catch(Exception e){
			e.printStackTrace();
			SessionFactoryUtil.shutDownSessionFactory();
		}
	}
}
