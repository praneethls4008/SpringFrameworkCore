package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name="one_to_one_passport")
public class PassportForPerson {

	@Id
	@Column(unique = true)
	@Min(value = 10, message = "passportNumber should not be less than length of 10")
	@Max(value = 10, message = "passportNumber  should not exceed length of 10")
	private int number;
	@NotNull
	private Date expiryDate;
	@NotNull 
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PassportForPerson [number=" + number + ", expiryDate=" + expiryDate + ", age=" + age + "]";
	}

	
}
