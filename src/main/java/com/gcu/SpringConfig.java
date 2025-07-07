package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.annotation.SessionScope;


import com.gcu.business.VehiclesBusinessService;
import com.gcu.business.VehiclesBusinessServiceInterface;

@Configuration
public class SpringConfig {

	@Bean(name="vehicleBusinessService", initMethod="init", destroyMethod="destroy")
	VehiclesBusinessServiceInterface getVehicleBusinessService() {
		return new VehiclesBusinessService();
	}
}
