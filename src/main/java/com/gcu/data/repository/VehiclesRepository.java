package com.gcu.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.VehicleEntity;

/**
 * Repository interface for Vehicle operations using Spring Data JDBC.
 * Provides CRUD operations and custom SQL queries if needed.
 */
@Repository
public interface VehiclesRepository extends CrudRepository<VehicleEntity, Integer> {

    /**
     * Retrieve all vehicles from the database.
     * @return a list of all VehicleEntity records
     */
    @Override
    @Query("SELECT * FROM vehicles")
    List<VehicleEntity> findAll();

    /**
     * Find a specific vehicle by its ID.
     * @param id the vehicle ID
     * @return an Optional of VehicleEntity
     */
    @Override
    Optional<VehicleEntity> findById(Integer id);

    /**
     * Save or update a vehicle entity.
     * @param vehicle the vehicle to save
     * @return the saved VehicleEntity
     */
    @Override
    VehicleEntity save(VehicleEntity vehicle);

    /**
     * Delete a vehicle by its ID.
     * @param id the vehicle ID
     */
    @Override
    void deleteById(Integer id);

    /**
     * Find all vehicles belonging to a customer by customerId.
     * @param customerId the ID of the customer
     * @return list of VehicleEntity
     */
    @Query("SELECT * FROM vehicles WHERE customerId = :customerId")
    List<VehicleEntity> findByCustomerId(Integer customerId);
}
