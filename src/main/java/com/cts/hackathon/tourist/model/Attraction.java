package com.cts.hackathon.tourist.model;


public class Attraction {

	private String place;
	private String description;

	public Attraction() {}
	
	public Attraction(String place, String description){
		this.place = place;
		this.description = description;
		
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
