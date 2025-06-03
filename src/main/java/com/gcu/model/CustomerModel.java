package com.gcu.model;

public class CustomerModel {
	private String firstName;
	private String lastName;
	private String customerId;
	
//	public CustomerModel(String firstName, String lastName, String customerId) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.customerId = customerId;
//	}
	
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
