package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.VehicleEntity;
import com.gcu.data.mapper.VehicleRowMapper;
import com.gcu.data.repository.VehiclesRepository;

/**
 * VehiclesDataService handles data access for vehicle records using both Spring JDBC and Spring Data.
 */
@Service
public class VehiclesDataService implements DataAccessInterface<VehicleEntity> {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    private final JdbcTemplate jdbcTemplateObject;

    /**
     * Constructor injection for DAO components.
     */
    public VehiclesDataService(VehiclesRepository vehiclesRepository, DataSource dataSource, JdbcTemplate jdbcTemplateObject) {
        this.vehiclesRepository = vehiclesRepository;
        this.jdbcTemplateObject = jdbcTemplateObject;
    }

    /**
     * CRUD find all vehicles in DB
     */
    @Override
    public List<VehicleEntity> findAll() {
        List<VehicleEntity> vehicles = new ArrayList<>();
        try {
            vehiclesRepository.findAll().forEach(vehicles::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    /**
     * CRUD find a vehicle by vehicle ID
     */
    @Override
    public VehicleEntity findById(int id) {
        String sql = "SELECT * FROM vehicles WHERE vehicleId = ?";
        try {
            List<VehicleEntity> result = jdbcTemplateObject.query(sql, new VehicleRowMapper(), id);
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            System.err.println("Error finding vehicle by ID: " + id);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * CRUD Find vehicles by customer ID
     * @param customerId
     * @return
     */
    public List<VehicleEntity> findByCustomerId(int customerId) {
        String sql = "SELECT * FROM vehicles WHERE customerId = ?";
        try {
            return jdbcTemplateObject.query(sql, new VehicleRowMapper(), customerId);
        } catch (Exception e) {
            System.err.println("Error finding vehicles by customer ID: " + customerId);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * CRUD add new Vehicle to DB
     */
    @Override
    public boolean create(VehicleEntity vehicle) {
        String sql = "INSERT INTO vehicles (customerId, color, year, make, model, plateState, plateNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            int rows = jdbcTemplateObject.update(sql,
                vehicle.getCustomerId(),
                vehicle.getColor(),
                vehicle.getYear(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getPlateState(),
                vehicle.getPlateNumber());
            return rows == 1;
        } catch (DataAccessException dae) {
            System.err.println("Error creating vehicle record.");
            dae.printStackTrace();
            return false;
        }
    }

    /**
     * CRUD update existing vehicles
     */
    @Override
    public boolean update(VehicleEntity vehicle) {
        String sql = "UPDATE vehicles SET color = ?, year = ?, make = ?, model = ?, plateState = ?, plateNumber = ? WHERE vehicleId = ?";
        try {
            int rows = jdbcTemplateObject.update(sql,
                vehicle.getColor(),
                vehicle.getYear(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getPlateState(),
                vehicle.getPlateNumber(),
                vehicle.getVehicleId());
            return rows == 1;
        } catch (DataAccessException dae) {
            System.err.println("Error updating vehicle with ID: " + vehicle.getVehicleId());
            dae.printStackTrace();
            return false;
        }
    }

    /**
     * CRUD Delete a vehicle by ID.
     */
    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM vehicles WHERE vehicleId = ?";
        try {
            int rowsAffected = jdbcTemplateObject.update(sql, id);
            if (rowsAffected > 0) {
                System.out.println("✅ Vehicle deleted with ID: " + id);
                return true;
            } else {
                System.out.println("❌ No vehicle found to delete with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error deleting vehicle with ID: " + id);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * CRUD Delete a vehicle by object.
     */
    @Override
    public boolean delete(VehicleEntity vehicle) {
        if (vehicle == null || vehicle.getVehicleId() <= 0) {
            System.out.println("❌ Invalid vehicle entity provided for deletion.");
            return false;
        }
        return deleteById(vehicle.getVehicleId());
    }
}

