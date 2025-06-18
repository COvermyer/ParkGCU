package com.gcu.data.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("vehicles")
public class VehicleEntity {

	@Column("customerId")
	Integer customerId;
	
	@Column("vehicleId")
	Integer vehicleId;
	
	@Column("color")
	String color;
	
	@Column("year")
	Integer year;
	
	@Column("make")
	String make;
	
	@Column("model")
	String model;	
	
	@Column("plateState")
	String plateState;
	
	@Column("plateNumber")
	String plateNumber;

	public VehicleEntity(Integer customerId, Integer vehicleId, String color, Integer year, String make, String model,
			String plateState, String plateNumber) {
		super();
		this.customerId = customerId;
		this.vehicleId = vehicleId;
		this.color = color;
		this.year = year;
		this.make = make;
		this.model = model;
		this.plateState = plateState;
		this.plateNumber = plateNumber;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlateState() {
		return plateState;
	}

	public void setPlateState(String plateState) {
		this.plateState = plateState;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
}
