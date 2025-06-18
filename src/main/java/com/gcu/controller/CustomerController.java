package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.CustomersBusinessServiceInterface;
import com.gcu.business.VehiclesBusinessServiceInterface;
import com.gcu.model.CustomerModel;
import com.gcu.model.VehicleModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomersBusinessServiceInterface customersService;
	
	@Autowired
	VehiclesBusinessServiceInterface vehiclesService;
	
	
	@GetMapping("/")
	public String display(Model model)
	{		
		model.addAttribute("title", "Customer Info");		
		model.addAttribute("customerModel", new CustomerModel());	
		model.addAttribute("registeredVehicles", new ArrayList<VehicleModel>());
		
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
		cm.setCustomerId(63596);
		
		model.addAttribute("customerModel", cm);
		model.addAttribute("registeredVehicles", vehiclesService.getVehicles());
		return "customerInfo";
	}
	
	@GetMapping("/all")
	public String displayAll(Model model)
	{
		List<CustomerModel> registeredCustomers = customersService.getCustomers();
		
		model.addAttribute("title", "Customers");
		model.addAttribute("registeredCustomers", registeredCustomers);
		
		return "customers";
	}
	
	@GetMapping("/new")
	public String displayNewCustomerPage(Model model)
	{
		model.addAttribute("title", "New Customer Registration");
		model.addAttribute("customerModel", new CustomerModel());
		
		return "customerRegistration";
	}
	
	@PostMapping("doCustomerRegistration")
	public String doCustomerRegistration(@Valid CustomerModel customerModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "New Customer Registration");
			System.out.println("Failed Registration detected");
			
			return "customerRegistration";
		}
		
		model.addAttribute("title", "Customer Info");
		model.addAttribute("customerModel", customerModel);
		model.addAttribute("registeredVehicles", new ArrayList<VehicleModel>());
		return "customerInfo";
	}
	
	@GetMapping("/ci")
	public String displayCustomerInfo(@RequestParam(value = "customerId") String customerId, Model model)
	{
		// TODO Error handling
		model.addAttribute("title", "Customer Info");
		model.addAttribute("customerModel", customersService.getCustomerById(customerId));
		model.addAttribute("registeredVehicles", vehiclesService.getVehiclesByCustomerId(customerId));
		return "customerInfo";
	}
}
