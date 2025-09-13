package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone;

import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service.PassportService;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service.PersonService;


public class Run {
	
	public static void main(String[] args) {
		PassportService.add(1111111111, 27, 2030);
		PassportService.add(1111111112, 67, 2030);
		PassportService.add(1111111113, 66, 2030);
		PassportService.add(1111111114, 25, 2030);
		PassportService.add(1111111115, 29, 2030);
		
		PersonService.add("pra", PassportService.get(1111111111));

		
//		PersonService.delete(152);
		

		PersonService.printAll();
		PassportService.printAll();
		
	}
	
	
}
