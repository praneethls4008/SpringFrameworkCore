package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany;

import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.service.AddressService;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.service.PassportService;

public class Run {
	
	public static void main(String[] args) {
		//add address
		AddressService.add("india", "telang", 502319);
		AddressService.add("india", "chennai", 400034);
		AddressService.add("india", "kerala", 102319);
		
		//add passport
		PassportService.add(1111111111, 27, 2030, AddressService.get(502319));
		PassportService.add(1111111112, 67, 2030, AddressService.get(502319));
		PassportService.add(1111111113, 66, 2030, AddressService.get(502319));
		PassportService.add(1111111114, 25, 2030, AddressService.get(400034));
		PassportService.add(1111111115, 29, 2030, AddressService.get(102319));
		
		//delete parent row
		AddressService.delete(502319); 
		
		//delete child from list
		AddressService.deletePassportFromList(102319, 1111111115);
		
		//print
		PassportService.printAll();
		AddressService.printAll();
		
	}
	
	
}
