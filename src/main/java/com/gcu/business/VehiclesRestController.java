package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * Returns vehicles as JSON from the VehicleBusinessService
	 * @return
	 */
	@GetMapping(path="/vehicles/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<VehicleModel> getVehiclesAsJson()
	{
		return vehiclesService.getVehicles();
	}
	
	/**
	 * Returns vehicles as XML from the VehicleBusinessService
	 * @return
	 */
	@GetMapping(path="/vehicles/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public VehicleList getVehiclesAsXml()
	{
		VehicleList vehicles = new VehicleList();
		vehicles.setVehicles(vehiclesService.getVehicles());
		return vehicles;
	}
}
