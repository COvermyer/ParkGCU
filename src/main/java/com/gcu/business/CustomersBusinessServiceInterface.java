package com.gcu.business;

import java.util.List;

import com.gcu.model.CustomerModel;

/**
 * Interface designs the contract for CustomersBusinessService
 */
public interface CustomersBusinessServiceInterface {

	public void init();
	public List<CustomerModel> getCustomers();
	public CustomerModel getCustomerById(String customerId);
	public boolean addCustomer(CustomerModel customer);
	public void destroy();
}
