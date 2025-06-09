package com.gcu.model;

public class VehicleModel {
	private String color;
	private String year;
	private String make;
	private String model;
	private String plateState;
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
