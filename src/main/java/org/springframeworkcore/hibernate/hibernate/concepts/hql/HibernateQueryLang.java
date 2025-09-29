package org.springframeworkcore.hibernate.hibernate.concepts.hql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="")
public class HibernateQueryLang {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String hobby;

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

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "HibernateObjectStates [id=" + id + ", name=" + name + ", hobby=" + hobby + "]";
	}
	
	
}
