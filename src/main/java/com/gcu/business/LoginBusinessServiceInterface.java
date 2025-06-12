package com.gcu.business;

public interface LoginBusinessServiceInterface {
	public void init();
	public boolean authenticate(String username, String password);
	public void destroy();
}
