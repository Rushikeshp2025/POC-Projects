package com.example.service.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PersonDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private int personAge;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	@Override
	public String toString() {
		return "PersonDetails{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", personAge=" + personAge +
				'}';
	}
}
