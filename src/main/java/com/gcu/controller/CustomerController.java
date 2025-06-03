package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.model.CustomerModel;
import com.gcu.model.VehicleModel;

@Controller
@RequestMapping("/c")
public class CustomerController {

	@GetMapping("/")
	public String display(Model model)
	{
		model.addAttribute("title", "Customer Info");		
		model.addAttribute("customerModel", new CustomerModel());
		return "customerInfo";
	}
	
	@GetMapping("/test")
	public String test(Model model)
	{
		// Define a new model with test values for customer model
		model.addAttribute("title", "Customer Info");
		CustomerModel cm = new CustomerModel();
		cm.setFirstName("Caleb");
		cm.setLastName("Overmyer");
		cm.setCustomerId("063596");
		
		List<VehicleModel> vehicles = new ArrayList<VehicleModel>();
		vehicles.add(new VehicleModel("Blue", "2015", "Jeep", "Patriot", "AZ", "8VA15M"));
		vehicles.add(new VehicleModel("Red", "2011", "Ford", "Focus", "AZ", "ANA8Y6"));
		vehicles.add(new VehicleModel("Green", "2006", "Vespa", "Gran Turismo", "AZ", "V3SPA"));
		cm.setRegisteredVehicles(vehicles);
		
		model.addAttribute("customerModel", cm);
		return "customerInfo";
	}
	
	@GetMapping("/all")
	public String displayAll(Model model)
	{
		List<CustomerModel> registeredCustomers = new ArrayList<CustomerModel>();
		
		// add a test Customer Model to the list
		CustomerModel cm = new CustomerModel();
		cm.setFirstName("Caleb");
		cm.setLastName("Overmyer");
		cm.setCustomerId("012345");
		registeredCustomers.add(cm);
		CustomerModel cm2 = new CustomerModel();
		cm2.setFirstName("Nora");
		cm2.setLastName("Marshall");
		cm2.setCustomerId("654321");
		registeredCustomers.add(cm2);
		
		model.addAttribute("title", "Customers");
		model.addAttribute("registeredCustomers", registeredCustomers);
		
		return "customers";
	}
	
	@GetMapping("/ci")
	public String displayCustomerInfo(@RequestParam("customerId") String customerId, Model model)
	{
		model.addAttribute("title", "Customer Info");
		CustomerModel cm = CustomerModel.getById(customerId);
		model.addAttribute("customerModel", cm);
		return "customerInfo";
	}
}
