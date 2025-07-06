package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.VehicleEntity;

public class VehicleRowMapper implements RowMapper<VehicleEntity> {
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
