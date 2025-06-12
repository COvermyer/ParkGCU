package com.gcu.business;

import java.util.List;

import com.gcu.model.VehicleModel;

/**
 * Interface defines behaviors for VehicleBusinessService
 */
public interface VehiclesBusinessServiceInterface {
	public void init();
	public List<VehicleModel> getVehicles();
	public List<VehicleModel> getVehiclesByCustomerId(String customerId);
	public boolean addVehicle(VehicleModel vehicle);
	public void destroy();
}
