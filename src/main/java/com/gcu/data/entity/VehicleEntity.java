package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Class to represent an entity in the vehicles DB table
 */
@Table("vehicles")
public class VehicleEntity {

    @Id
    @Column("vehicleId")
    private Integer vehicleId;

    @Column("customerId")
    private Integer customerId;

    @Column("color")
    private String color;

    @Column("year")
    private Integer year;

    @Column("make")
    private String make;

    @Column("model")
    private String model;

    @Column("plateState")
    private String plateState;

    @Column("plateNumber")
    private String plateNumber;

    /**
     * Default constructor
     */
    public VehicleEntity() {}

    /**
     * Parameterized constructor
     * @param vehicleId
     * @param customerId
     * @param color
     * @param year
     * @param make
     * @param model
     * @param plateState
     * @param plateNumber
     */
    public VehicleEntity(Integer vehicleId, Integer customerId, String color, Integer year, String make, String model,
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

    /**
     * Getter for vehicle id
     * @return
     */
    public Integer getVehicleId() {
        return vehicleId;
    }

    /**
     * Setter for vehicle id
     * @param vehicleId
     */
    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Getter for customer Id
     * @return
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Setter for customer id
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
     * setter for color
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
     * setter for year
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Getter for make
     * @return
     */
    public String getMake() {
        return make;
    }

    /**
     * Setter for make
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
     * getter for plate state
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
     * setter for plate number
     * @param plateNumber
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
