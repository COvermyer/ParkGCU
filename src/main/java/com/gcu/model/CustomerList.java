package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Class represents a List of CustomerModels, used primarily for XML serialization
 */
@XmlRootElement(name="customers")
public class CustomerList {

	private List<CustomerModel> customers = new ArrayList<CustomerModel>();

	/**
	 * returns a List of CustomerModels
	 * @return 
	 */
	@XmlElement(name="customer")
	public List<CustomerModel> getCustomers() {
		return customers;
	}

	/**
	 * Sets the List of CustomerModels held by the class
	 * @param customers
	 */
	public void setCustomers(List<CustomerModel> customers) {
		this.customers = customers;
	}
}
