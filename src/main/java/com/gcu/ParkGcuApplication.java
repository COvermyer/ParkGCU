package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main class
 */
@SpringBootApplication
@ComponentScan({ "com.gcu" })
public class ParkGcuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkGcuApplication.class, args);
	}

}
