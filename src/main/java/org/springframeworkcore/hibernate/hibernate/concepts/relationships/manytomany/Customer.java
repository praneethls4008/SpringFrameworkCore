package org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="many_to_many_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	//mappedBy wont create new table but ues/refers columnId of below field(customers) mentioned, table will be create for other travel table 
	//by default fetch type is lazy for collections
	//cascade is actions to be performed on child when any action taken on  parent
	@ManyToMany(mappedBy = "customers")
	private List<TravelPackage> travelPackages;
	
	
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
	public List<TravelPackage> getTravelPackages() {
		return travelPackages;
	}
	public void setTravelPackages(List<TravelPackage> travelPackages) {
		this.travelPackages = travelPackages;
	}
	
	public void addToTravelPackage(TravelPackage travelPackage) {
		travelPackages.add(travelPackage);
	}
	
	public void removeFromTravelPackage(TravelPackage travelPackage) {
		travelPackages.remove(travelPackage);
	}
	
	@Override
	public String toString() {
		return "\nCustomer [id=" + id + ", travelPackages=" + travelPackages + "]";
	}
	
	
	
}
