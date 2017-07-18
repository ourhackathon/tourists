package com.cts.hackathon.tourist.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cts.hackathon.tourist.model.Attraction;
import com.cts.hackathon.tourist.model.City;

public class PlacesData {

	private Map<City, List<Attraction>> pointsOfInterest = new HashMap<City, List<Attraction>>();
	
	public Map<City, List<Attraction>> getPointsOfInterest() {
		return pointsOfInterest;
	}


	public void setPointsOfInterest(Map<City, List<Attraction>> pointsOfInterest) {
		this.pointsOfInterest = pointsOfInterest;
	}
	
	public PlacesData() {
		
		City mysore = new City("Mysore", "22°C Rainy", "12.2958° N, 76.6394° E");
		List<Attraction> mysoreList = new ArrayList<Attraction>();  
		Attraction a1 = new Attraction();
		a1.setDescripation("");
		a1.setPlace("Mysore Palace");
		mysoreList.add(a1);
		mysoreList.add(new Attraction("Brindavan Gardens", "Gardens"));
		mysoreList.add(new Attraction("Mysore Zoo", "Zoo"));
		mysoreList.add(new Attraction("Chamundeshwari Temple", "Temple"));
		pointsOfInterest.put(mysore, mysoreList);
		
		
		City delhi = new City("Delhi", "32°C Rainy", "12.2958° N, 76.6394° E");
		List<Attraction> delhiList = new ArrayList<Attraction>();  
		Attraction d1 = new Attraction();
		d1.setDescripation("");
		d1.setPlace("India Gate");
		delhiList.add(d1);
		delhiList.add(new Attraction("Red Fort", "Fort"));
		delhiList.add(new Attraction("Lotus Temple", "Temple"));
		delhiList.add(new Attraction("Akshardham Temple", "Temple"));
		pointsOfInterest.put(delhi, delhiList);
		
		
		City kerla = new City("Kerala", "20°C cloudy", "12.2958° S, 76.6394° W");
		List<Attraction> kerlaList = new ArrayList<Attraction>();  
		Attraction k1 = new Attraction();
		k1.setDescripation("");
		k1.setPlace("kochi");
		kerlaList.add(k1);
		kerlaList.add(new Attraction("Waynad", "Hill Station"));
		kerlaList.add(new Attraction("Munnar", "Hill Station"));
		kerlaList.add(new Attraction("thekkady", "National Park"));
		pointsOfInterest.put(kerla, kerlaList);
		
		
		City sikkim = new City("Sikkim", "20°C Cloudy", "12.2958° N, 76.6394° E");
		List<Attraction> sikkimList = new ArrayList<Attraction>();  
		Attraction s1 = new Attraction();
		s1.setDescripation("");
		s1.setPlace("Yuksome");
		sikkimList.add(s1);
		sikkimList.add(new Attraction("Tsomgo Lake", "Lake"));
		sikkimList.add(new Attraction("Nathula Pass", "Pass"));
		sikkimList.add(new Attraction("Lachung", "Snow destination"));
		pointsOfInterest.put(sikkim, sikkimList);
		
		
	}
}
