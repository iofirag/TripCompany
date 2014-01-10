package com.shenkar.tripcompany;




public class Trip {
	int tripId;
	String name;
	String startDate;
	String endDate;
	int numOfTravelers;
	double ratePerTraveler;
	
	

	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getNumOfTravelers() {
		return numOfTravelers;
	}
	public void setNumOfTravelers(int numOfTravelers) {
		this.numOfTravelers = numOfTravelers;
	}
	public double getRatePerTraveler() {
		return ratePerTraveler;
	}
	public void setRatePerTraveler(double ratePerTraveler) {
		this.ratePerTraveler = ratePerTraveler;
	}
}
