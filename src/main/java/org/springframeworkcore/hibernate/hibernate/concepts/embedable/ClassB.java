package org.springframeworkcore.hibernate.hibernate.concepts.embedable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ClassB {
	private String courseName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "ClassB [courseName=" + courseName + "]";
	}
	
}
