package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service.AddressService;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service.PassportService;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service.PersonService;

import java.util.Date;

public class Run {
	
	public static void main(String[] args) {
		AddressService.add("india", "telang", 502319);
		AddressService.add("india", "chennai", 400034);
		AddressService.add("india", "kerala", 102319);
		PassportService.add(1111111111, 27, 2030, AddressService.get(502319));
		PassportService.add(1111111112, 67, 2030, AddressService.get(502319));
		PassportService.add(1111111113, 66, 2030, AddressService.get(502319));
		PassportService.add(1111111114, 25, 2030, AddressService.get(400034));
		PassportService.add(1111111115, 29, 2030, AddressService.get(102319));
		
//		PersonService.add("pra", PassportService.get(1111111111));
		AddressService.delete(502319); 
		
//		PersonService.delete(152);
		
		AddressService.deletePassportFromList(102319, 1111111115);
		
//		PersonService.printAll();
		PassportService.printAll();
		AddressService.printAll();
		
	}
	
	
}
