package com.foodTruckLocator.foodTruckLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodTruckLocatorApplication {

	private static final Logger log = LoggerFactory.getLogger(FoodTruckLocatorApplication.class);
	
	public static void main(String[] args) {
		log.info("Initializing FoodTruckLocatorApplication...");
		SpringApplication.run(FoodTruckLocatorApplication.class, args);
	}

}
