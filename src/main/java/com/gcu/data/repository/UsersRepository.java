package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.UserEntity;

/**
 * CRUD REPOSITORY instance for customers table to pull user data from MySQL database
 */
@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Integer> {

	/**
	 * CTUD method to find all username/password pairs
	 */
	@Override
	@Query(value="SELECT `customerId`, `username`, `password` FROM `customers`")
	public List<UserEntity> findAll();
	
	/**
	 * CRUD method to find a specific User by username
	 * @param username
	 * @return
	 */
	@Query(value="SELECT `customerId`, `username`, `password` FROM `customers` WHERE username = :user")
	public UserEntity findByUsername(@Param("user") String username);
}
