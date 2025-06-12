package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.VehicleModel;

/**
 * Service to handle Vehicle DB pulls
 */
public class VehiclesBusinessService implements VehiclesBusinessServiceInterface {

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
	public List<VehicleModel> getVehicles() {
		// TODO Insert DB call to pull vehicles here
		List<VehicleModel> vehicles = new ArrayList<VehicleModel>();
		
		// # TESTING
		VehicleModel v1 = new VehicleModel("BLU", "2015", "Jeep", "Patriot", "AZ", "ABC123");
		VehicleModel v2 = new VehicleModel("RED", "2011", "Ford", "Focus", "CO", "EFG456");
		VehicleModel v3 = new VehicleModel("BLU", "2019", "Toyota", "Tacoma", "CA", "HIJ789");
		
		vehicles.add(v1);
		vehicles.add(v2);
		vehicles.add(v3);
		// # END TESTING
		
		return vehicles;
	}

	/**
	 * get Method to get vehicles based on a specific customerId
	 */
	@Override
	public List<VehicleModel> getVehiclesByCustomerId(String customerId) {
		// TODO Requires implementation once DB is added
		List<VehicleModel> vehicles = new ArrayList<VehicleModel>();
		
		// # TESTING
		VehicleModel v1 = new VehicleModel("BLU", "2015", "Jeep", "Patriot", "AZ", "ABC123");
		VehicleModel v2 = new VehicleModel("RED", "2011", "Ford", "Focus", "CO", "EFG456");
		
		vehicles.add(v1);
		vehicles.add(v2);
		// # END TESTING
		
		return vehicles;
	}
	
	/**
	 *  Method to add a vehicle to DB
	 */
	@Override
	public boolean addVehicle(VehicleModel vehicle)
	{
		// TODO add DB insert her for new vehicle
		System.out.println(String.format("Vehicle %s %s added", vehicle.getMake(), vehicle.getModel()));
		return true;
	}

	/**
	 * Destruction method for service.
	 */
	@Override
	public void destroy() {
		System.out.println("Vehicle Business Service terminated.");
	}
}
