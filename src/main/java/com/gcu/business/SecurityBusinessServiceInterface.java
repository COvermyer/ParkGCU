package com.gcu.business;

/**
 * Interface designs contract for Security Services
 */
public interface SecurityBusinessServiceInterface {
    void init();
    boolean authenticate(String username, String password);
    void destroy();
    int getAuthenticatedCustomerId();
}
