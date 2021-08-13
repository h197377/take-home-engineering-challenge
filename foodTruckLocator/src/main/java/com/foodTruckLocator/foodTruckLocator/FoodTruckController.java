package com.foodTruckLocator.foodTruckLocator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodTruckController {
	private final static String _CSV_PATH = "src/main/resources/assets/csv/Mobile_Food_Facility_Permit.csv";
	private Map<String, FoodTruck> foodTrucksMap = intializeFoodTrucks();

	// TODO:
	// void insert_a_truck(applicant, facilityType, locationDescription, address,
	// block, permit, status=Requested, scheduleUrl...)
	// List<Truck> get_trucks_from_block(block)
	@GetMapping("/get-foodtruck")
	public FoodTruck getFoodTruck(@RequestParam(value = "locationId", defaultValue = "1") String locationId) {
		Random rand = new Random();

		return foodTrucksMap.get(String.valueOf(rand.nextInt(4 + 1)));
	}

	@Bean
	public static Map<String, FoodTruck> intializeFoodTrucks() {
		Map<String, FoodTruck> fts = new HashMap<>();

		try {
			File file = new File(_CSV_PATH);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			String[] tempArr;
			while ((line = br.readLine()) != null) {
				tempArr = line.split(",");
				for (String tempStr : tempArr) {
					System.out.print(tempStr + " ");
				}
				System.out.println();
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return fts;
	}
}