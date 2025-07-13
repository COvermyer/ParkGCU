package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.CustomersBusinessServiceInterface;
import com.gcu.model.CustomerList;
import com.gcu.model.CustomerModel;

/**
 * Rest Controller managing Customer services
 */
@RestController
@RequestMapping("/services")
public class CustomersRestController {

	@Autowired
	CustomersBusinessServiceInterface customersService;
	
	@GetMapping(path="customers/getCustomerById/{id}",  produces= {MediaType.APPLICATION_JSON_VALUE})
	public CustomerModel getCustomerById(@PathVariable String id)
	{		
		return customersService.getCustomerById(id);
	}
	
	/**
	 * Returns customers as JSON from the CustomersBusinessService
	 * @return
	 */
	@GetMapping(path="/customers/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<CustomerModel> getCustomersAsJson()
	{
		return customersService.getCustomers();
	}
	
	/**
	 * Returns customers as XML from the CustomersBusinessService
	 * @return
	 */
	@GetMapping(path="/customers/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public CustomerList getCustomersAsXml()
	{
		CustomerList customers = new CustomerList();
		customers.setCustomers(customersService.getCustomers());
		return customers;
	}
}
