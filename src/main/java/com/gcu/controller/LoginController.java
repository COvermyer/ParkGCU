package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.LoginBusinessServiceInterface;
import com.gcu.model.CustomerModel;
import com.gcu.model.LoginModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	LoginBusinessServiceInterface security;
	
	@GetMapping("/")
	public String displayLogin(Model model)
	{
		model.addAttribute("title", "User Login");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors() || !security.authenticate(loginModel.getUsername(), loginModel.getPassword()))
		{
			model.addAttribute("title", "User Login");
			System.out.println("failed login detected");
			return "login";
		}
		
		model.addAttribute("title", "Customer Info");
		model.addAttribute("customerModel", new CustomerModel());

		return "customerInfo"; // FIXME
	}
	

}
