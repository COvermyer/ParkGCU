package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	/**
	 * Method to display the "Home" page
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title", "Home");
		return "home";
	}
}
