package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.VehiclesDataService;
import com.gcu.data.entity.VehicleEntity;
import com.gcu.model.VehicleModel;

/**
 * Service to handle Vehicle DB pulls
 */
public class VehiclesBusinessService implements VehiclesBusinessServiceInterface {

	@Autowired
	VehiclesDataService service;
	
	/**
	 * Initialization method for service
	 */
	@Override
	public void init() {
		System.out.println("Vehicle Business Service initialized.");
	}

	/**
	 * get method to get all registered vehicles
	 */
	@Override
	public List<VehicleModel> getVehicles() 
	{
		List<VehicleEntity> vehiclesEntity = service.findAll();
		List<VehicleModel> vehiclesDomain = new ArrayList<VehicleModel>();
		for (VehicleEntity e : vehiclesEntity)
			vehiclesDomain.add(new VehicleModel(e.getCustomerId(),
												e.getVehicleId(),
												e.getColor(),
												e.getYear(),
												e.getMake(),
												e.getModel(),
												e.getPlateState(),
												e.getPlateNumber()));		
		
		return vehiclesDomain;
	}

	/**
	 * get Method to get vehicles based on a specific customerId
	 */
	@Override
	public List<VehicleModel> getVehiclesByCustomerId(String customerId) 
	{
		List<VehicleEntity> vehiclesEntity = service.findByCustomerId(Integer.valueOf(customerId));
		List<VehicleModel> vehiclesDomain = new ArrayList<VehicleModel>();
		for (VehicleEntity e : vehiclesEntity)
			vehiclesDomain.add(new VehicleModel(e.getCustomerId(),
												e.getVehicleId(),
												e.getColor(),
												e.getYear(),
												e.getMake(),
												e.getModel(),
												e.getPlateState(),
												e.getPlateNumber()));		
		
		return vehiclesDomain;
	}
	
	/**
	 *  Method to add a vehicle to DB
	 */
	@Override
	public boolean addVehicle(VehicleModel vehicle)
	{
		return service.create(new VehicleEntity(vehicle.getCustomerId(),
											0,
											vehicle.getColor(),
											vehicle.getYear(),
											vehicle.getMake(),
											vehicle.getModel(),
											vehicle.getPlateState(),
											vehicle.getPlateNumber()));
	}

	@Override
	public boolean deleteVehicleById(int id) {
		// Create an empty vehicle entity with the given ID.
		VehicleEntity ve = new VehicleEntity(0, id, "", 0, "", "", "", "");
		return service.delete(ve);
	}
	
	/**
	 * Destruction method for service.
	 */
	@Override
	public void destroy() {
		System.out.println("Vehicle Business Service terminated.");
	}
}
