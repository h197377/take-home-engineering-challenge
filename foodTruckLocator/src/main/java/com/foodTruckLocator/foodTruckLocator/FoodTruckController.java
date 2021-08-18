package com.foodTruckLocator.foodTruckLocator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodTruckController {
	private final static String _CSV_PATH = "src/main/resources/assets/csv/Mobile_Food_Facility_Permit.csv";
	private final static String _CSV_DELIMITER = ",";
	private Map<String, FoodTruck> foodTrucksMap = intializeFoodTrucks();
	private Map<String, List<FoodTruck>> foodTrucksByBlockMap = intializeFoodTrucksByBlock(foodTrucksMap);

	@GetMapping(value = { "/getFoodTruck/{locationId}", "/getFoodTruck" })
	public FoodTruck getFoodTruck(@PathVariable(required = false) String locationId) {
		System.out.println(String.format("Attempting to get foodtruck with locationId: %s", locationId));
		return foodTrucksMap.getOrDefault(locationId, null);
	}

	@GetMapping(value = { "/getFoodTrucksByBlock/{block}", "/getFoodTrucksByBlock" })
	public List<FoodTruck> getFoodTrucksByBlock(@PathVariable(required = false) String block) {
		System.out.println(String.format("Attempting to get foodtruck with block: %s", block));
		return foodTrucksByBlockMap.getOrDefault(block == null || block.isEmpty() ? "EMPTY" : block, new ArrayList<>());
	}

//	@PostMapping("insertFoodTruck")
//	public void insertFoodTruck(FoodTruck ft) {
//
//		// TODO add input validations
//		foodTrucksMap.put(ft.getLocationId(), ft);
//	}

	@Bean
	public static Map<String, FoodTruck> intializeFoodTrucks() {
		Map<String, FoodTruck> fts = new HashMap<>();

		try {
			File file = new File(_CSV_PATH);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			String[] row;
			while ((line = br.readLine()) != null) {
				row = line.split(_CSV_DELIMITER);
				String locationId = row[0];
				// TODO: make the element parsing dynamic instead of hard coded order
				FoodTruck ft = new FoodTruck(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8],
						row[9], row[10], row[11], row[12], row[13], row[14], row[15], row[16], row[17], row[18],
						row[19], row[20], row[21], row[22], row[23]);
				fts.put(locationId, ft);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return fts;
	}

	@Bean
	private Map<String, List<FoodTruck>> intializeFoodTrucksByBlock(Map<String, FoodTruck> fts) {
		Map<String, List<FoodTruck>> foodTrucksByBlockMap = new HashMap<>();

		for (String locationId : fts.keySet()) {
			FoodTruck ft = fts.get(locationId);
			String blockName = ft.getBlock().isEmpty() ? "EMPTY" : ft.getBlock();
			List<FoodTruck> ftsByBlock = foodTrucksByBlockMap.getOrDefault(blockName, new ArrayList<>());

			ftsByBlock.add(ft);
			foodTrucksByBlockMap.put(blockName, ftsByBlock);
		}
		return foodTrucksByBlockMap;
	}
}