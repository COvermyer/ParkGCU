package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.VehicleEntity;

/**
 * RowMapper class for vehicles table of MySQL database 
 */
public class VehicleRowMapper implements RowMapper<VehicleEntity> {
    
	/**
	 * Mapping method for MySQL Database
	 */
	@Override
    public VehicleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new VehicleEntity(
            rs.getInt("vehicleId"),
            rs.getInt("customerId"),
            rs.getString("color"),
            rs.getInt("year"),
            rs.getString("make"),
            rs.getString("model"),
            rs.getString("plateState"),
            rs.getString("plateNumber")
        );
    }
}
