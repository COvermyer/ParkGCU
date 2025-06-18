package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.VehicleEntity;

public interface VehiclesRepository extends CrudRepository<VehicleEntity, Integer> {

	@Override
	@Query(value="SELECT * FROM vehicles")
	public List<VehicleEntity> findAll();	
}
