package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gcu.data.entity.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Integer> {

	@Override
	@Query(value="SELECT `customerId`, `username`, `password` FROM `customers`")
	public List<UserEntity> findAll();
	
	@Query(value="SELECT `customerId`, `username`, `password` FROM `customers` WHERE username = :user")
	public UserEntity findByUsername(@Param("user") String username);
}
