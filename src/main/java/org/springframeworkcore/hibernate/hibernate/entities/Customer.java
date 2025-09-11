package org.springframeworkcore.hibernate.hibernate.entities;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", length = 20 , nullable = false )
    private String name;
	
	@Transient
	private String firstName;
	
	@Transient
	private String lastName;
	
    private String email;
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] profilePicture;
    
    @Temporal(TemporalType.TIMESTAMP)
    Date date;
    
    
	public byte[] getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", date=" + date + "]";
	}
	
	
    
	
    
}
