package com.gcu.business;

import java.util.List;

import com.gcu.model.VehicleModel;

/**
 * Interface defines behaviors for VehicleBusinessService
 */
public interface VehiclesBusinessServiceInterface {
    void init();
    List<VehicleModel> getVehicles();
    List<VehicleModel> getVehiclesByCustomerId(String customerId);
    boolean addVehicle(VehicleModel vehicle);
    boolean deleteVehicleById(int id);
    boolean updateVehicle(VehicleModel vehicle);
    void destroy();
    VehicleModel getVehicleById(int id);

}
