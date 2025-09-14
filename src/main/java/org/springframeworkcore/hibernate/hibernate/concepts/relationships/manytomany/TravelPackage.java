package org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
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
	
	
	/*
	 * mappedBy - wont create new table but ues/refers columnId of below field(travelPackages) mentioned 
	 * joinTable - can be used to name new table name and table operations
	 * joincolumns - used to name columns and operations (travelId)
	 * inversejoincolumns - used to name columns and operations for other table pm(custome_id)
	 * lazy loading - loads when get or size() is called on collection like list set map
	 * hibernate creates proxy of entity class and collections are wrapped in PersistentBag
	 * whole transaction should happen in single session for lazy loading if not throws seeion expiry error
	 * eager - loads on spot
	 */
	@ManyToMany//(mappedBy = "travelPackages") 
	@JoinTable( name = "many_to_many_travel_customer_mapping", 
		joinColumns = {@JoinColumn(name = "travelPackage_id")},
		inverseJoinColumns = {@JoinColumn(name = "invcustomer_id")}
	)
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
		return "\n\tTravelPackage [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
