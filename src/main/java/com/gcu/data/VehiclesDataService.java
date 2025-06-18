package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.gcu.ParkGcuApplication;
import com.gcu.data.entity.VehicleEntity;
import com.gcu.data.mapper.VehicleRowMapper;
import com.gcu.data.repository.VehiclesRepository;

@Service
public class VehiclesDataService implements DataAccessInterface<VehicleEntity> {

    private final ParkGcuApplication parkGcuApplication;

	@Autowired
	private VehiclesRepository vehiclesRepository;
	private DataSource datasource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-default constructor for CI
	 * @param vehicleRepository
	 * @param datasource
	 * @param jdbcTemplateObject
	 */
	public VehiclesDataService(VehiclesRepository vehiclesRepository, DataSource datasource, JdbcTemplate jdbcTemplateObject, ParkGcuApplication parkGcuApplication) 
	{
		this.vehiclesRepository = vehiclesRepository;
		this.datasource = datasource;
		this.jdbcTemplateObject = jdbcTemplateObject;
		this.parkGcuApplication = parkGcuApplication;
	}

	@Override
	public List<VehicleEntity> findAll() {
		List<VehicleEntity> vehicles = new ArrayList<VehicleEntity>();
		try
		{
			// Get all vehicle entities
			Iterable<VehicleEntity> vehiclesIterable = vehiclesRepository.findAll();
			
			// Convert to a list and return
			vehiclesIterable.forEach(vehicles::add);
		} catch (Exception e) { e.printStackTrace(); }
		
		return vehicles;
	}

	@Override
	public VehicleEntity findById(int id) {
		VehicleEntity vehicle = null;
		
		String sql = "SELECT * FROM vehicles WHERE vehicleId = ?";
		try {
			List<VehicleEntity> results = jdbcTemplateObject.query(sql, new VehicleRowMapper(), id);
			if(results.size() == 1)
				vehicle = results.get(0);	
		} catch (Exception e) { e.printStackTrace(); }
		
		return vehicle;
	}
	
	/**
	 * Returns a list of vehicles based on their associated customer id
	 * @param id
	 * @return
	 */
	public List<VehicleEntity> findByCustomerId(int id)
	{
		List<VehicleEntity> vehicles = null;
		String sql = "SELECT * FROM vehicles where customerId = ?";
		try
		{
			vehicles = jdbcTemplateObject.query(sql, new VehicleRowMapper(), id);
		} catch (Exception e) { e.printStackTrace(); }
		return vehicles;
	}

	@Override
	public boolean create(VehicleEntity vehicle) 
	{		
		String sql = "INSERT INTO vehicles (customerId, color, year, make, model, plateState, plateNumber) values (?, ?, ?, ?, ?, ?, ?)";
		int num = -1;
		try
		{
			num = jdbcTemplateObject.update(sql,
					vehicle.getCustomerId(),
					vehicle.getColor(),
					vehicle.getYear(),
					vehicle.getMake(),
					vehicle.getModel(),
					vehicle.getPlateState(),
					vehicle.getPlateNumber());
		} catch(DataAccessException d) { num = 0; }
		catch (Exception e) { e.printStackTrace(); }
		
		System.out.println("Rows affected: " + num);
		
		return (num == 1) ? true : false;
	}

	@Override
	public boolean update(VehicleEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(VehicleEntity vehicle) {
		String sql = "DELETE FROM vehicles WHERE vehicleId = ?";
		int num = -1;
		try
		{
			num = jdbcTemplateObject.update(sql, vehicle.getVehicleId());
		} 
		catch (DataAccessException d) { num = 0; }
		catch (Exception e) { e.printStackTrace(); }
		
		return (num <= 1) ? true : false;
	}

}
