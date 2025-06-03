package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.CustomerModel;

@Controller
@RequestMapping("/")
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
		model.addAttribute("customerModel", cm);
		return "customerInfo";
	}
}
