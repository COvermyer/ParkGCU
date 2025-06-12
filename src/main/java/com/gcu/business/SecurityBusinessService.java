package com.gcu.business;

public class SecurityBusinessService implements LoginBusinessServiceInterface {

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
		// TODO run authentication via DB
		
	    // #TESTING
		if (username.equals("user") && password.equals("pass"))
			return true;
		
		return false;
	}

	/**
	 * Destruction method for Security Business Service
	 */
	@Override
	public void destroy() {
		System.out.println("Security Service terminated.");

	}

}
