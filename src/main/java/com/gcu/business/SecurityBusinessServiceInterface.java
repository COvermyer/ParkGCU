package com.gcu.business;

/**
 * Interface designs contract for Security Services
 */
public interface SecurityBusinessServiceInterface {
	public void init();
	public boolean authenticate(String username, String password);
	public void destroy();
}
