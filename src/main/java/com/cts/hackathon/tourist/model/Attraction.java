package com.cts.hackathon.tourist.model;


public class Attraction {

	private String place;
	private String descripation;

	public Attraction() {}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescripation() {
		return descripation;
	}

	public void setDescripation(String descripation) {
		this.descripation = descripation;
	}

	public Attraction(String place, String descripation) {
		super();
		this.place = place;
		this.descripation = descripation;
	}
	
	

}
