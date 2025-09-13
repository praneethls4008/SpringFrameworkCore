package org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="many_to_many_travels")
public class TravelPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private double price;
	
	@ManyToMany(mappedBy = "travelPackages")
	private List<Customer> customers = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return this.price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public void addToCustomers(Customer customer) {
		this.customers.add(customer);
	}
	
	public void removeFromCustomers(Customer customer) {
		this.customers.remove(customer);
	}
	
	@Override
	public String toString() {
		return "\nTravelPackage [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
