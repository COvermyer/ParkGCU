package com.gcu.model;

import jakarta.validation.constraints.NotEmpty;

public class VehicleModel {
	@NotEmpty(message="Color is a required field")
	private String color;
	
	@NotEmpty(message="Year is a required field")
	private String year;
	
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
		this.color = "";
		this.year = "";
		this.make = "";
		this.model = "";
		this.plateState = "";
		this.plateNumber = "";
	}
	
	public VehicleModel(String color, String year, String make, String model, String plateState, String plateNumber) {
		super();
		this.color = color;
		this.year = year;
		this.make = make;
		this.model = model;
		this.plateState = plateState;
		this.plateNumber = plateNumber;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
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
