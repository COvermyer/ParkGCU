package com.gcu.data.entity;

import org.springframework.data.relational.core.mapping.Column;

public class UserEntity {
	
	@Column("customerId")
	Integer id;
	
	@Column("username")
	String username;
	
	@Column("password")
	String password;

	public UserEntity()
	{
		this.id = -1;
		this.username = "";
		this.password = "";
	}
	
	public UserEntity(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
