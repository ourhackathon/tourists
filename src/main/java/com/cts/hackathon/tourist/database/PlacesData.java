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
		
		
	}
}
