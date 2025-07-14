package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.VehiclesDataService;
import com.gcu.data.entity.VehicleEntity;
import com.gcu.model.VehicleModel;

/**
 * Business service layer for vehicle-related operations.
 */
@Service
public class VehiclesBusinessService implements VehiclesBusinessServiceInterface {

    @Autowired
    private VehiclesDataService service;

    /**
     * Service init method
     */
    @Override
    public void init() {
        System.out.println("Vehicle Business Service initialized.");
    }

    /**
     * CRUD method to get all vehicle models from DB
     */
    @Override
    public List<VehicleModel> getVehicles() {
        List<VehicleEntity> vehiclesEntity = service.findAll();
        List<VehicleModel> vehiclesDomain = new ArrayList<>();

        for (VehicleEntity e : vehiclesEntity) {
            vehiclesDomain.add(convertToModel(e));
        }

        return vehiclesDomain;
    }

    /**
     * CRUD method to get a Vehicle by ID
     */
    @Override
    public List<VehicleModel> getVehiclesByCustomerId(String customerId) {
        List<VehicleEntity> vehiclesEntity = service.findByCustomerId(Integer.parseInt(customerId));
        List<VehicleModel> vehiclesDomain = new ArrayList<>();

        for (VehicleEntity e : vehiclesEntity) {
            vehiclesDomain.add(convertToModel(e));
        }

        return vehiclesDomain;
    }

    /**
     * CRUD method to add a vehicle
     */
    @Override
    public boolean addVehicle(VehicleModel vehicle) {
        VehicleEntity entity = new VehicleEntity(
            vehicle.getCustomerId(),
            0,
            vehicle.getColor(),
            vehicle.getYear(),
            vehicle.getMake(),
            vehicle.getModel(),
            vehicle.getPlateState(),
            vehicle.getPlateNumber()
        );
        return service.create(entity);
    }

    /**
     * CRUD method to delete a vehicle by vehicle ID
     */
    @Override
    public boolean deleteVehicleById(int id) {
        VehicleEntity vehicle = service.findById(id);
        if (vehicle == null) {
            System.out.println("Vehicle not found in DB for deletion with ID: " + id);
            return false;
        }
        return service.delete(vehicle);
    }


    /**
     * CRUD: Retrieve a single vehicle by its ID.
     */
    public VehicleModel getVehicleById(int id) {
        VehicleEntity entity = service.findById(id);
        return entity != null ? convertToModel(entity) : null;
    }

    /**
     * CRUD: Update an existing vehicle.
     */
    public boolean updateVehicle(VehicleModel vehicle) {
        VehicleEntity entity = new VehicleEntity(
        		vehicle.getVehicleId(),
        		vehicle.getCustomerId(),
        		vehicle.getColor(),
        		vehicle.getYear(),
        		vehicle.getMake(),
        		vehicle.getModel(),
        		vehicle.getPlateState(),
        		vehicle.getPlateNumber()
        );
        return service.update(entity);
    }

    /**
     * Utility method to convert a VehicleEntity (entity) to a VehicleModel (domain)
     * @param e
     * @return
     */
    private VehicleModel convertToModel(VehicleEntity e) {
        return new VehicleModel(
        		e.getVehicleId(),
        		e.getCustomerId(),
        		e.getColor(),
        		e.getYear(),
        		e.getMake(),
        		e.getModel(),
        		e.getPlateState(),
        		e.getPlateNumber()
        );
    }

    /**
     * Service destruction method
     */
    @Override
    public void destroy() {
        System.out.println("Vehicle Business Service terminated.");
    }
}
