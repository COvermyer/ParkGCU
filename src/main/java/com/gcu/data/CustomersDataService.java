package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.CustomerEntity;
import com.gcu.data.mapper.CustomerRowMapper;
import com.gcu.data.repository.CustomersRepository;

@Service
public class CustomersDataService implements DataAccessInterface<CustomerEntity> {

	@Autowired
	private CustomersRepository customersRepository;
	private DataSource datasource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-default constructor for CI
	 * @param customersRepository
	 * @param datasource
	 * @param jdbcTemplateObject
	 */
	public CustomersDataService(CustomersRepository customersRepository, DataSource datasource, JdbcTemplate jdbcTemplateObject) 
	{
		this.customersRepository = customersRepository;
		this.datasource = datasource;
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	@Override
	public List<CustomerEntity> findAll() {
		List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
		try
		{
			// Get all customer entities
			Iterable<CustomerEntity> customersIterable = customersRepository.findAll();
			
			// Convert to a list and return
			customersIterable.forEach(customers::add);
		} catch (Exception e) { e.printStackTrace(); }
		return customers;
	}

	@Override
	public CustomerEntity findById(int id) {
		CustomerEntity customer = null;
		
		String sql = "SELECT * FROM customers WHERE customerId = ?";
		try {
			List<CustomerEntity> results = jdbcTemplateObject.query(sql, new CustomerRowMapper(), id);
			if(results.size() == 1)
				customer = results.get(0);
		} catch (Exception e) { e.printStackTrace(); }
		
		return customer;
	}

	@Override
	public boolean create(CustomerEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CustomerEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CustomerEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

}
