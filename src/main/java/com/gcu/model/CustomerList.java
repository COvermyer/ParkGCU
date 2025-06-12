package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customers")
public class CustomerList {

	private List<CustomerModel> customers = new ArrayList<CustomerModel>();

	@XmlElement(name="customer")
	public List<CustomerModel> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerModel> customers) {
		this.customers = customers;
	}
}
