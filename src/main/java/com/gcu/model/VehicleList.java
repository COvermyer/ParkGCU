package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Defines a List of VehicleModels
 */
@XmlRootElement(name="vehicles")
public class VehicleList {
	
	private List<VehicleModel> vehicles = new ArrayList<VehicleModel>();

	/**
	 * Getter for all Vehicle Models in a compatible format for XML conversion
	 * @return
	 */
	@XmlElement(name="vehicle")
	public List<VehicleModel> getVehicles() {
		return vehicles;
	}

	/**
	 * Setter for vehicles
	 * @param vehicles
	 */
	public void setVehicles(List<VehicleModel> vehicles) {
		this.vehicles = vehicles;
	}
}
