package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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

    // No-arg constructor (required by Spring)
    public VehicleEntity() {}

    // All-args constructor
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

    // Getters and Setters
    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
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
