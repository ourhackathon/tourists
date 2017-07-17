package com.cts.hackathon.tourist.model;

public class City {
	
	
	private String city;
	private String weather;
	private String coordinates;


	

	public City(String city, String weather, String coordinates) {
		super();
		this.city = city;
		this.weather = weather;
		this.coordinates = coordinates;
		
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getWeather() {
		return weather;
	}


	public void setWeather(String weather) {
		this.weather = weather;
	}


	public String getCoordinates() {
		return coordinates;
	}


	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	

}
