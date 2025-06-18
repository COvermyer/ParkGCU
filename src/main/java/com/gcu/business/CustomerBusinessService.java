package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.CustomersDataService;
import com.gcu.data.entity.CustomerEntity;
import com.gcu.model.CustomerModel;

/**
 * Service to manage Customer DB
 */
public class CustomerBusinessService implements CustomersBusinessServiceInterface {

	@Autowired
	CustomersDataService service;
	
	/**
	 * Initialization method for service
	 */
	@Override
	public void init() {
		System.out.println("Customer Business Service initialized.");
	}

	/**
	 * Returns a list of customers
	 */
	@Override
	public List<CustomerModel> getCustomers() {
		List<CustomerEntity> customersEntity = new ArrayList<CustomerEntity>();
		List<CustomerModel> customersDomain = new ArrayList<CustomerModel>();
		for (CustomerEntity e : customersEntity)
			customersDomain.add(new CustomerModel(e.getCustomerId(),
													e.getFirstName(),
													e.getLastName(),
													e.getEmail(),
													e.getPhoneNumber(),
													e.getUsername(),
													e.getPassword()));
		
		return customersDomain;
	}

	/**
	 * Method to get a specific customer by a customerId
	 */
	@Override
	public CustomerModel getCustomerById(String customerId) {
		CustomerModel customer = new CustomerModel();
		CustomerEntity e = service.findById(Integer.valueOf(customerId));
		
		customer.setCustomerId(e.getCustomerId());
		customer.setFirstName(e.getFirstName());
		customer.setLastName(e.getLastName());
		customer.setEmail(e.getEmail());
		customer.setPhoneNumber(e.getPhoneNumber());
		customer.setUsername(e.getUsername());
		customer.setPassword(e.getPassword());
		
		return customer;
	}
	
	/**
	 * Method to add a customer to the DB
	 */
	@Override
	public boolean addCustomer(CustomerModel customer)
	{
		System.out.println(String.format("Customer %s %s added.", customer.getFirstName(), customer.getLastName()));
		return false;
	}
	
	/**
	 * Destruction method for service
	 */
	@Override
	public void destroy() {
		System.out.println("Customer Business Service terminated.");
	}
}
