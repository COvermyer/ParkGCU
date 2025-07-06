package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.CustomersDataService;

/**
 * Security service for running user authentications.
 */
public class SecurityBusinessService implements SecurityBusinessServiceInterface {

    private int authenticatedCustomerId = -1;

    @Autowired
    private CustomersDataService service;

    /**
     * Initialization logic (optional, tied to initMethod in SpringConfig)
     */
    @Override
    public void init() {
        System.out.println("SecurityBusinessService initialized.");
    }

    /**
     * Authenticates the login credentials provided by the user
     *
     * @param username The input username
     * @param password The input password
     * @return true if authentication is successful, false otherwise
     */
    @Override
    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            System.out.println("Authentication failed: username or password is null");
            return false;
        }

        int customerId = service.validateUserLogin(username, password);

        if (customerId <= 0) {
            System.out.println("Authentication failed: invalid credentials");
            return false;
        }

        this.authenticatedCustomerId = customerId;
        System.out.println("Authentication success: customer ID " + customerId);
        return true;
    }

    /**
     * Cleanup or termination logic (tied to destroyMethod in SpringConfig)
     */
    @Override
    public void destroy() {
        System.out.println("SecurityBusinessService terminated.");
    }

    /**
     * Get the authenticated customer ID
     *
     * @return ID of the authenticated customer
     */
    public int getAuthenticatedCustomerId() {
        return authenticatedCustomerId;
    }
}
