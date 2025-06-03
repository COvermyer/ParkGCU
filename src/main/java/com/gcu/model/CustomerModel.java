package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
	private String firstName;
	private String lastName;
	private String customerId;
	private List<VehicleModel> registeredVehicles;
	
//	public CustomerModel(String firstName, String lastName, String customerId) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.customerId = customerId;
//	}
	public CustomerModel()
	{
		setRegisteredVehicles(new ArrayList<VehicleModel>());
	}
	
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
	public List<VehicleModel> getRegisteredVehicles() {
		return registeredVehicles;
	}
	public void setRegisteredVehicles(List<VehicleModel> registeredVehicles) {
		this.registeredVehicles = registeredVehicles;
	}
	
	public boolean isValid()
	{
		if (firstName == null || firstName.equals(""))
			return false;
		
		if (lastName == null || lastName.equals(""))
			return false;
		
		if (customerId == null || customerId.equals(""))
			return false;
		
		return true;
	}
	
	public static CustomerModel getById(String customerId)
	{
		CustomerModel cm = new CustomerModel();
		
		// Insert JDBC code to pull customer info
		// from DB here
		
		// example code
		cm.setFirstName("Caleb");
		cm.setLastName("Overmyer");
		cm.setCustomerId(customerId);
		
		return cm;
	}

	
}
