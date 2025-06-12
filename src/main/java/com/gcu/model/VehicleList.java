package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vehicles")
public class VehicleList {
	
	private List<VehicleModel> vehicles = new ArrayList<VehicleModel>();

	@XmlElement(name="vehicle")
	public List<VehicleModel> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleModel> vehicles) {
		this.vehicles = vehicles;
	}
}
