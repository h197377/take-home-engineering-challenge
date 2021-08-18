package com.foodTruckLocator.foodTruckLocator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FoodTruckLocatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	// getFoodTruck tests
	@Test
	public void noParamGetFoodTruckShouldReturnEmpty() throws Exception {
		this.mockMvc.perform(get("/getFoodTruck")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$").doesNotExist());
	}

	@Test
	public void paramGetFoodTruckShouldReturnMessage() throws Exception {
		String existingLocationId = "735315";
		this.mockMvc.perform(get(String.format("/getFoodTruck/%s", existingLocationId))).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.locationId").value(existingLocationId));
	}

	// getFoodTrucksByBlock tests
	@Test
	public void noParamGetFoodTrucksByBlockShouldReturnEmptyBlockTrucks() throws Exception {
		this.mockMvc.perform(get("/getFoodTrucksByBlock")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$").isNotEmpty());

		String emptyBlockName = "";
		this.mockMvc.perform(get(String.format("/getFoodTrucksByBlock/%s", emptyBlockName))).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$").isNotEmpty());
	}

	@Test
	public void paramGetFoodTrucksByBlockShouldReturnMessage() throws Exception {
		String existingBlock = "3549";
		this.mockMvc.perform(get(String.format("/getFoodTrucksByBlock/%s", existingBlock))).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$").isNotEmpty())
				.andExpect(jsonPath("$[0].block").value(existingBlock));
	}

	// insertFoodTruck tests
	@Test
	public void noContentInsertFoodTruckShouldThrowError() throws Exception {
		this.mockMvc.perform(
				post("/insertFoodTruck").contentType(MediaType.APPLICATION_JSON).content("").characterEncoding("utf-8"))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	public void contentInsertFoodTruckShouldInsert() throws Exception {
		String fakeFoodTruckData = "{ \"locationId\":\"123456789\", \"location\":\"location\", "
				+ "\"applicant\":\"Fake Applicant\", \"address\":\"5 THE EMBARCADERO\", "
				+ "\"permit\":\"15MFF-0159\", \"schedule\":\"fake_schedule.pdf\", "
				+ "\"received\":\"2015-12-31\", \"priorPermit\":\"0\", \"location\":\"location\" }";
		this.mockMvc.perform(post("/insertFoodTruck").contentType(MediaType.APPLICATION_JSON).content(fakeFoodTruckData)
				.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();
	}
	
    // TODO: add tests to cover overwriting FoodTrucks by locationId cases	
}
