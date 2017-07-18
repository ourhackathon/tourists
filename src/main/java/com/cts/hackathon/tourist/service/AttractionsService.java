package com.cts.hackathon.tourist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cts.hackathon.tourist.database.PlacesData;
import com.cts.hackathon.tourist.model.Attraction;
import com.cts.hackathon.tourist.model.City;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AttractionsService {

	public AttractionsService() {
		// TODO Auto-generated constructor stub
		
	}
		
	//returning all tourist spots
	
		public List<Attraction> getAttractions(){
			Attraction attraction1 = new Attraction("Mysore Palace", "Its a palace of Mysore royale king");
			Attraction attraction2= new Attraction("Brindavan Garden", "Its a garden built near the KSR dam.");
			
			List<Attraction> attractionList = new ArrayList<Attraction>();
			attractionList.add(attraction1);
			attractionList.add(attraction2);
			return attractionList;
		}
		
		//Returning only one tourist spot
		public String getAttraction(String geoCity){
			
			JsonObject failureMessage = new JsonParser()
			.parse("{\"speech\": \"No matching places found for the mentioned city\" ,\"displayText\": \"No matching places found for the mentioned city\"}")
			.getAsJsonObject();
			if (geoCity != "") {
				System.out.println("Geo-city parameter is..." + geoCity);
				List<Attraction> a1 = new ArrayList<Attraction>();
				PlacesData p1 = new PlacesData();
				Map<City, List<Attraction>> m1 = p1.getPointsOfInterest();
				for(Entry<City, List<Attraction>> e: m1.entrySet()){
					if(e.getKey().getCity().equals(geoCity)){
						a1 = e.getValue();
					} else {
						return failureMessage.toString();
					}
				}
				StringBuffer success = new StringBuffer("Places of attractions in "+geoCity + " are: ");
				for(int i = 0; i < a1.size(); i++) {
					success.append(a1.get(i).getPlace() + ", ");
				}
				success.deleteCharAt(success.length()-2);
				String speech = "{\"speech\":\"";
				String displayText = "\",\"displayText\": \"Its beautiful place to visit\"}";
						
				success.insert(0, speech);
				success.insert(success.length(), displayText);
				String jsonstring = success.toString();
				JsonObject successMessage = new JsonParser().parse(jsonstring).getAsJsonObject();
				
				return successMessage.toString();

			} else {
				return failureMessage.toString();
			}
		}
	



}
