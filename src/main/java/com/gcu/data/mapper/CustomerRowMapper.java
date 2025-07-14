package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.gcu.data.entity.CustomerEntity;

/**
 * RowMapper class for customers table of MySQL database 
 */
public class CustomerRowMapper implements RowMapper<CustomerEntity> {

	/**
	 * Mapping method for MySQL Database
	 */
    @Override
    public CustomerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerEntity(
            rs.getInt("customerId"),
            rs.getString("firstName"),
            rs.getString("lastName"),
            rs.getString("email"),
            rs.getString("phoneNumber"), 
            rs.getString("username"),
            rs.getString("password")
        );
    }
}
