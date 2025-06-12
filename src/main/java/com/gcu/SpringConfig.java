package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.CustomerBusinessService;
import com.gcu.business.CustomersBusinessServiceInterface;
import com.gcu.business.LoginBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.business.VehiclesBusinessService;
import com.gcu.business.VehiclesBusinessServiceInterface;

@Configuration
public class SpringConfig {

	@Bean(name="securityBusinessService", initMethod="init", destroyMethod="destroy")
	LoginBusinessServiceInterface getSecurityService()
	{
		return new SecurityBusinessService();
	}
	
	@Bean(name="customerBusinessService", initMethod="init", destroyMethod="destroy")
	CustomersBusinessServiceInterface getCustomerBusinessService()
	{
		return new CustomerBusinessService();
	}
	
	@Bean(name="vehicleBusinessService", initMethod="init", destroyMethod="destroy")
	VehiclesBusinessServiceInterface getVehicleBusinessService()
	{
		return new VehiclesBusinessService();
	}
}
