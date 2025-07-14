package com.gcu.data.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Class to represent a n entity from the customers table of the DB
 */
@Table("customers")
public class CustomerEntity {

	@Column("customerId")
	Integer customerId;
	
	@Column("firstName")
	String firstName;
	
	@Column("lastName")
	String lastName;
	
	@Column("email")
	String email;
	
	@Column("phoneNumber")
	String phoneNumber;
	
	@Column("username")
	String username;
	
	@Column("password")
	String password;
	
	/**
	 * Parameterized constructor
	 * @param customerId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param username
	 * @param password
	 */
	public CustomerEntity(Integer customerId, String firstName, String lastName, String email, String phoneNumber,
			String username, String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}

	/**
	 * Getter for customer Id
	 * @return
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * setter for customer ID
	 * @param customerId
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * Getter for first name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for last name
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for email
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getter for phone number
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * setter for phone number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * getter for username
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * setter for username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getter for password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
