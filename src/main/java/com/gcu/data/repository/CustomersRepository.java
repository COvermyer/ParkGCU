package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.CustomerEntity;

/**
 * CRUD REPOSITORY instance for customers table of MySQL database
 */
@Repository
public interface CustomersRepository extends CrudRepository<CustomerEntity, Integer> {

	/**
	 * CRUD method to find all customers
	 */
	@Override
	@Query(value="SELECT * FROM customers")
	public List<CustomerEntity> findAll();
}
