package com.gcu.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class VehicleModel {
	
	private Integer customerId;
	
	private Integer vehicleId;
	
	@NotEmpty(message="Color is a required field")
	private String color;
	
	@Min(value=1900, message="Year must be greater than 1900")
	@Max(value=2100, message="Year must be less than 2100")
	private Integer year;
	
	@NotEmpty(message="Make is a required field")
	private String make;
	
	@NotEmpty(message="Model is a required field")
	private String model;
	
	@NotEmpty(message="State is a required field")
	private String plateState;
	
	@NotEmpty(message="Plate is a required field")
	private String plateNumber;
	
	public VehicleModel()
	{
		super();
		this.customerId = 0;
		this.color = "";
		this.year = 0;
		this.make = "";
		this.model = "";
		this.plateState = "";
		this.plateNumber = "";
	}
	
	public VehicleModel(Integer customerId, Integer vehicleId, String color, Integer year, String make, String model, String plateState, String plateNumber) {
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
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getPlateState() {
		return plateState;
	}
	public void setPlateState(String plateState) {
		this.plateState = plateState;
	}
	
	public boolean isValid()
	{	
		if (color.equals(""))
			return false;
		
		if (year.equals(""))
			return false;
		
		if (make.equals(""))
			return false;
		
		if (model.equals(""))
			return false;
		
		if (plateState.equals(""))
			return false;
		
		if (plateNumber.equals(""))
			return false;
		
		return true;
	}
}
