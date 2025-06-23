package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.CustomersDataService;

/**
 * Security service for running user authentications
 */
public class SecurityBusinessService implements SecurityBusinessServiceInterface {

	private int authenticatedCustomerId;

	@Autowired
	CustomersDataService service;
	
	/**
	 * Start up method for Security Business Service
	 */
	@Override
	public void init() {
		System.out.println("Security Service initialized.");

	}

	/**
	 * Authenticates the login credentials provided by the user
	 * @param username
	 * @param password
	 * @return Boolean result indicating if the credentials are valid.
	 */
	@Override
	public boolean authenticate(String username, String password) {
		
		int possible = service.validateUserLogin(username, password);
		
		if (possible == -1)
			return false;
		else
		{
			setAuthenticatedCustomerId(possible);
			return true;
		}
	}

	/**
	 * Destruction method for Security Business Service
	 */
	@Override
	public void destroy() {
		System.out.println("Security Service terminated.");

	}

	public int getAuthenticatedCustomerId() {
		return authenticatedCustomerId;
	}

	public void setAuthenticatedCustomerId(int authenticatedCustomerId) {
		this.authenticatedCustomerId = authenticatedCustomerId;
	}

}
