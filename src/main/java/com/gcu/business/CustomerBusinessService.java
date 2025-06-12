package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.CustomerModel;

public class CustomerBusinessService implements CustomersBusinessServiceInterface {

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
		// TODO Implement customer data pull from DB here
		List<CustomerModel> customers = new ArrayList<CustomerModel>();
		
		// #TESTING
		// populate a list with fake customer data
		CustomerModel cm1 = new CustomerModel();
		cm1.setFirstName("Caleb");
		cm1.setLastName("Overmyer");
		cm1.setCustomerId("123456");
		cm1.setEmail("MyEmail@email.org");
		cm1.setPhoneNumber("555-555-5555");
		cm1.setUsername("COvermyer");
		cm1.setPassword("pass");
		
		CustomerModel cm2 = new CustomerModel();
		cm2.setFirstName("Nora");
		cm2.setLastName("Marshall");
		cm2.setCustomerId("123456");
		cm2.setEmail("MyEmail@email.org");
		cm2.setPhoneNumber("555-555-5555");
		cm2.setUsername("NMarshall");
		cm2.setPassword("pass");
		
		CustomerModel cm3 = new CustomerModel();
		cm3.setFirstName("Randy");
		cm3.setLastName("Wendt");
		cm3.setCustomerId("123456");
		cm3.setEmail("MyEmail@email.org");
		cm3.setPhoneNumber("555-555-5555");
		cm3.setUsername("RWendt");
		cm3.setPassword("pass");
		
		customers.add(cm1);
		customers.add(cm2);
		customers.add(cm3);
		// #END TESTING
		
		return customers;
	}

	/**
	 * Method to get a specific customer by a customerId
	 */
	@Override
	public CustomerModel getCustomerById(String customerId) {
		// TODO Implement data pull from DB here
		CustomerModel customer = new CustomerModel();
		
		// # TESTING
		customer.setFirstName("Nora");
		customer.setLastName("Marshall");
		customer.setEmail("NMarshall@email.org");
		customer.setPhoneNumber("(555)555-5555");
		customer.setUsername("NMarshall");
		customer.setPassword("pass");
		customer.setCustomerId(customerId);
		// # END TESTING
		
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
