package com.gcu.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * This class represents the model for a vehicle in the application.
 * It is used to transfer data between the controller and the view.
 */
public class VehicleModel {

    // Unique identifier for the vehicle (primary key)
    private Integer vehicleId;

    // ID of the customer that owns the vehicle
    @NotNull(message = "Customer ID is required")
    private Integer customerId;

    // Color of the vehicle
    @NotEmpty(message = "Color is a required field")
    private String color;

    // Year the vehicle was manufactured (between 1900 and 2100)
    @NotNull(message = "Year is required")
    @Min(value = 1900, message = "Year must be greater than 1900")
    @Max(value = 2100, message = "Year must be less than 2100")
    private Integer year;

    // Vehicle make (e.g., Toyota, Ford)
    @NotEmpty(message = "Make is a required field")
    private String make;

    // Vehicle model (e.g., Camry, Mustang)
    @NotEmpty(message = "Model is a required field")
    private String model;

    // State where the license plate was issued
    @NotEmpty(message = "State is a required field")
    private String plateState;

    // Vehicle's license plate number
    @NotEmpty(message = "Plate is a required field")
    private String plateNumber;

    /**
     * Default constructor
     */
    public VehicleModel() {
    	this.vehicleId = 0;
        this.customerId = 0;
        this.color = "";
        this.year = 0;
        this.make = "";
        this.model = "";
        this.plateState = "";
        this.plateNumber = "";
    	
    }

    /**
     * Parameterized constructor
     */
    public VehicleModel(Integer vehicleId, Integer customerId, String color, Integer year, String make, String model,
                        String plateState, String plateNumber) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.color = color;
        this.year = year;
        this.make = make;
        this.model = model;
        this.plateState = plateState;
        this.plateNumber = plateNumber;
    }

    // Getters and setters for all fields

    /**
     * Getter for vehicleId
     * @return
     */
    public Integer getVehicleId() {
        return vehicleId;
    }

    /**
     * Setter for vehicleId
     * @param vehicleId
     */
    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Getter for customerId
     * @return
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Setter for customerId
     * @param customerId
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter for color
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for color
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * getter for year
     * @return
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Setter for year
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * getter for make
     * @return
     */
    public String getMake() {
        return make;
    }

    /**
     * setter for make
     * @param make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Getter for model
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter for model
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Getter for plate state
     * @return
     */
    public String getPlateState() {
        return plateState;
    }

    /**
     * Setter for plate state
     * @param plateState
     */
    public void setPlateState(String plateState) {
        this.plateState = plateState;
    }

    /**
     * Getter for plate number
     * @return
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * Setter for plate number
     * @param plateNumber
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * Additional manual validation logic.
     * This helps ensure fields aren't empty/null before saving.
     * Used in controller to supplement JSR validation.
     */
    public boolean isValid() {
        if (customerId == null || year == null)
            return false;

        if (color == null || color.isBlank())
            return false;

        if (make == null || make.isBlank())
            return false;

        if (model == null || model.isBlank())
            return false;

        if (plateState == null || plateState.isBlank())
            return false;

        if (plateNumber == null || plateNumber.isBlank())
            return false;

        return true;
    }
}
