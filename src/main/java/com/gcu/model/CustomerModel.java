package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

//import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerModel {
	
	// Direct Info
	private String customerId;
	
	@NotEmpty(message="First Name is a required field")
	private String firstName;
	
	@NotEmpty(message="Last Name is a required field")
	private String lastName;
	
	@Email(message="Please enter a valid email address")
	@NotEmpty(message="Email is a required field")
	private String email;
	
	@NotEmpty(message="Phone is a required field")
	@Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}", message="Please enter a valid phone number")
	private String phoneNumber;
	
	@NotNull(message="Username is a required field")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters")
	private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	
	// Associated Info
	private VehicleList registeredVehicles;

	public CustomerModel()
	{
		registeredVehicles = new VehicleList();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<VehicleModel> getRegisteredVehicles() {
		return registeredVehicles.getVehicles();
	}
	public void setRegisteredVehicles(List<VehicleModel> vehicles) {
		this.registeredVehicles.setVehicles(vehicles);
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
		// TODO Depreciate this
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
