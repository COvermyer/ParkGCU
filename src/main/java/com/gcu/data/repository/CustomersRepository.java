package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.CustomerEntity;

public interface CustomersRepository extends CrudRepository<CustomerEntity, Integer> {

	@Override
	@Query(value="SELECT * FROM customers")
	public List<CustomerEntity> findAll();
}
