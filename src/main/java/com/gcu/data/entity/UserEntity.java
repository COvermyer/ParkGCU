package com.gcu.data.entity;

import org.springframework.data.relational.core.mapping.Column;

/**
 * Class to represent a DB entry for a User
 * 
 * pulls from customer table ignoring unnecessary data
 */
public class UserEntity {
	
	@Column("customerId")
	Integer id;
	
	@Column("username")
	String username;
	
	@Column("password")
	String password;

	/**
	 * Default constructor
	 */
	public UserEntity()
	{
		this.id = -1;
		this.username = "";
		this.password = "";
	}
	
	/**
	 * Parameterized constructor
	 * @param id
	 * @param username
	 * @param password
	 */
	public UserEntity(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	/**
	 * Getter for ID
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter for ID
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
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
