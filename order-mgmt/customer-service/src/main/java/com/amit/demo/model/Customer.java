package com.amit.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/*
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 * 
	 * public String getFirstName() { return firstName; }
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 * 
	 * public int getAge() { return age; }
	 * 
	 * public void setAge(int age) { this.age = age; }
	 * 
	 * public int getMobileNo() { return mobileNo; }
	 * 
	 * public void setMobileNo(int mobileNo) { this.mobileNo = mobileNo; }
	 * 
	 * public String getEmailId() { return emailId; }
	 * 
	 * public void setEmailId(String emailId) { this.emailId = emailId; }
	 */

	private String firstName;

	private String lastName;
	
	private int age;
	
	private int mobileNo;
	
	private String emailId;
	

	/*
	 * protected Customer() { }
	 * 
	 * public Customer(String firstName, String lastName, int age, int mobileNo,
	 * String emailId) { this.firstName = firstName; this.lastName = lastName;
	 * this.age = age; this.mobileNo = mobileNo; this.emailId = emailId; }
	 * 
	 * @Override public String toString() { return String.
	 * format("Customer[id=%d, firstName='%s', lastName='%s', age='%d', mobileNo='%d', emailId='%s']"
	 * , id, firstName, lastName, age, mobileNo, emailId); }
	 */
}