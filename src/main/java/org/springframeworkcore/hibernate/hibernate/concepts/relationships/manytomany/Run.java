package org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany;

import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.service.TravelPackageService;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.service.CustomerService;


public class Run {
	
	public static void main(String[] args) {
		
		TravelPackageService.add("kerlaTrip", 40000);
		TravelPackageService.add("manaliTrip", 30000);
		TravelPackageService.add("goaTrip", 50000);
		
		CustomerService.add("praneeth");
		CustomerService.add("reddy");
		CustomerService.add("random1");
		CustomerService.add("random2");
		
		
		CustomerService.addToTravelPackages(1, 1);
		CustomerService.addToTravelPackages(1, 2);
		CustomerService.addToTravelPackages(1, 3);
		
		CustomerService.addToTravelPackages(2, 1);
		
		CustomerService.addToTravelPackages(3, 1);
		CustomerService.addToTravelPackages(3, 2);
		
		CustomerService.removeFromTravelPackages(1, 3);
		
		TravelPackageService.printAll();
		CustomerService.printAll();
		
	}
	
	
}
