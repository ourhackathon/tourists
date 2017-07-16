package com.cts.hackathon.tourist.service;

import java.util.ArrayList;
import java.util.List;
import com.cts.hackathon.tourist.model.Attraction;

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
		public Attraction getAttraction(){
			
			Attraction attraction2= new Attraction("Brindavan Garden", "Its a garden built near the KSR dam.");
			return attraction2;
		}
	



}
