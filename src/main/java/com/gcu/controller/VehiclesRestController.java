package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.VehiclesBusinessServiceInterface;
import com.gcu.model.VehicleList;
import com.gcu.model.VehicleModel;

/**
 * Rest Controller managing vehicle services
 */
@RestController
@RequestMapping("/services")
public class VehiclesRestController {

	@Autowired
	VehiclesBusinessServiceInterface vehiclesService;
	
	/**
	 * REST API method for returning a specific vehicle by vehicle ID
	 * @param id A String containing a vehicle's unique ID number
	 * @return VehicleModel as JSON
	 */
	@GetMapping(path="/vehicles/getVehicle/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public VehicleModel getVehicleByVehicleId(@PathVariable int id)
	{
		return vehiclesService.getVehicleById(id);
	}
	
	/**
	 * REST API method for returning all vehicles associated with a Customer's CustomerID
	 * @param id A String containing a customer's unique ID number
	 * @return A List of VehicleModels
	 */
	@GetMapping(path="/vehicles/getVehiclesByCustomerId/{id}",  produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<VehicleModel> getVehiclesByCustomerId(@PathVariable String id)
	{
		return vehiclesService.getVehiclesByCustomerId(id);
	}
	
	/**
	 * REST API method to get all vehicles from database as JSON
	 * @return Returns vehicles as JSON from the VehiclesBusinessService
	 */
	@GetMapping(path="/vehicles/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<VehicleModel> getVehiclesAsJson()
	{
		return vehiclesService.getVehicles();
	}
	
	/**
	 * REST API method to get all vehicles from database as JSON
	 * @return Returns vehicles as XML from the VehiclesBusinessService
	 */
	@GetMapping(path="/vehicles/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public VehicleList getVehiclesAsXml()
	{
		VehicleList vehicles = new VehicleList();
		vehicles.setVehicles(vehiclesService.getVehicles());
		return vehicles;
	}
}
