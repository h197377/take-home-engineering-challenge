package com.foodTruckLocator.foodTruckLocator;

public class FoodTruck {
	private String locationId;
	private String applicant;
	private String facilityType;
	private String cnn;
	private String locationDescription;
	private String address;
	private String blockLot;
	private String block;
	private String lot;
	private String permit;
	private String status;
	private String foodItems;
	private String x;
	private String y;
	private String latitude;
	private String longitude;
	private String schedule;
	private String daysHours;
	private String noiSent;
	private String approved;
	private String received;
	private String priorPermit;
	private String expirationDate;
	private String location;

	public FoodTruck(String locationId, String applicant, String facilityType, String cnn, String locationDescription,
			String address, String blockLot, String block, String lot, String permit, String status, String foodItems,
			String x, String y, String latitude, String longitude, String schedule, String daysHours, String noiSent,
			String approved, String received, String priorPermit, String expirationDate, String location) {
		this.locationId = locationId;
		this.applicant = applicant;
		this.facilityType = facilityType;
		this.cnn = cnn;
		this.locationDescription = locationDescription;
		this.address = address;
		this.blockLot = blockLot;
		this.block = block;
		this.lot = lot;
		this.permit = permit;
		this.status = status;
		this.foodItems = foodItems;
		this.x = x;
		this.y = y;
		this.latitude = latitude;
		this.longitude = longitude;
		this.schedule = schedule;
		this.daysHours = daysHours;
		this.noiSent = noiSent;
		this.approved = approved;
		this.received = received;
		this.priorPermit = priorPermit;
		this.expirationDate = expirationDate;
		this.location = location;
	}
	
	public FoodTruck() {
		
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public String getCnn() {
		return cnn;
	}

	public void setCnn(String cnn) {
		this.cnn = cnn;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlockLot() {
		return blockLot;
	}

	public void setBlockLot(String blockLot) {
		this.blockLot = blockLot;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDaysHours() {
		return daysHours;
	}

	public void setDaysHours(String daysHours) {
		this.daysHours = daysHours;
	}

	public String getNoiSent() {
		return noiSent;
	}

	public void setNOISent(String noiSent) {
		this.noiSent = noiSent;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	public String getPriorPermit() {
		return priorPermit;
	}

	public void setPriorPermit(String priorPermit) {
		this.priorPermit = priorPermit;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return String.format("FoodTruck \nlocationId: %s, ", this.locationId);
	}

}
