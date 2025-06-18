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

import com.gcu.business.VehiclesBusinessServiceInterface;
import com.gcu.model.VehicleModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	VehiclesBusinessServiceInterface vehiclesService;
	
	@GetMapping("/all")
	public String displayVehicles(Model model)
	{
		model.addAttribute("title", "Registered Vehicles");
		model.addAttribute("registeredVehicles", vehiclesService.getVehicles());
		return "vehicles";
	}
	
	@GetMapping("/new")
	public String displayVehicleRegistration(Model model)
	{
		model.addAttribute("title", "New Vehicle Registration");
		model.addAttribute("vehicleModel", new VehicleModel());
		return "vehicleRegistration";
	}
	
	@PostMapping("/doVehicleRegistration")
	public String doVehicleRegistration(@Valid VehicleModel vehicleModel, BindingResult bindingResult, Model model)
	{
		/*
		 * Return to form if:
		 * - Form has errors
		 * - VehicleModel is not valid
		 * - Add attempt fails
		 */
		//FIXME: Need to give an error message for a bad customer ID
		if (bindingResult.hasErrors() || !vehicleModel.isValid() ||
				!vehiclesService.addVehicle(vehicleModel))
		{
			model.addAttribute("title", "New Vehicle Registration");
			System.out.println("failed vehicle registration detected");
			return "vehicleRegistration";
		}
		
		// Pass to the vehicle summary page on success
		model.addAttribute("title", "Registered Vehicles");
		model.addAttribute("registeredVehicles", vehiclesService.getVehicles());
		return "vehicles";
	}
}
