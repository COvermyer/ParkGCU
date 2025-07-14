package com.gcu.model;

//import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Model class for a Customer
 */
public class CustomerModel {
	
	// Direct Info
	private Integer customerId;
	
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
	
	/**
	 * Default constructor
	 */
	public CustomerModel()
	{
		super();
	}
	
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
	public CustomerModel(Integer customerId, @NotEmpty(message = "First Name is a required field") String firstName,
			@NotEmpty(message = "Last Name is a required field") String lastName,
			@Email(message = "Please enter a valid email address") @NotEmpty(message = "Email is a required field") String email,
			@NotEmpty(message = "Phone is a required field") @Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "Please enter a valid phone number") String phoneNumber,
			@NotNull(message = "Username is a required field") @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") String username,
			@NotNull(message = "Password is a required field") @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") String password) {
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
	 * Getter for first name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Setter for first name
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
	 * Getter for customerId
	 * @return
	 */
	public Integer getCustomerId() {
		return customerId;
	}
	
	/**
	 * Setter for customerId
	 * @param customerId
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	 * Getter for phone number
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Setter for phone number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Getter for username
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Setter for username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Getter for password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Setter for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
