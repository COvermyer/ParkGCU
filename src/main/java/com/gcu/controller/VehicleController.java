package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.VehicleModel;

@Controller
@RequestMapping("/v")
public class VehicleController {

//	@GetMapping("/default")
//	public String defaultView(Model model)
//	{
//		model.addAttribute("title", "Registered Vehicles");
//		model.addAttribute("registeredVehicles", new ArrayList<VehicleModel>());
//		return "vehicles";
//	}	
	
	@GetMapping("/all")
	public String displayVehicles(Model model)
	{
		model.addAttribute("title", "Registered Vehicles");
		
		List<VehicleModel> vehicles = new ArrayList<VehicleModel>();
		vehicles.add(new VehicleModel("Blue", "2015", "Jeep", "Patriot", "AZ", "8VA15M"));
		vehicles.add(new VehicleModel("Red", "2011", "Ford", "Focus", "AZ", "ANA8Y6"));
		vehicles.add(new VehicleModel("Green", "2006", "Vespa", "Gran Turismo", "AZ", "V3SPA"));
		
		model.addAttribute("registeredVehicles", vehicles);
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
	public String doVehicleRegistration(VehicleModel vehicleModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors() || !vehicleModel.isValid())
		{
			model.addAttribute("title", "New Vehicle Registration");
			System.out.println("failed vehicle registration detected");
			return "vehicleRegistration";
		}
		
		
		
		model.addAttribute("title", "Registered Vehicles");
		// The commit for adding the vehicle to the DB should go here, passed through VehicleModel
		
		// TEMP
		List<VehicleModel> vehicles = new ArrayList<VehicleModel>();
		vehicles.add(vehicleModel);
		model.addAttribute("registeredVehicles", vehicles);
		return "vehicles";
	}
}
