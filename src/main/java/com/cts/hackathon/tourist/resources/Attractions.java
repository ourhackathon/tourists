package com.cts.hackathon.tourist.resources;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import com.cts.hackathon.tourist.database.PlacesData;
import com.cts.hackathon.tourist.model.Attraction;
import com.cts.hackathon.tourist.model.City;
import com.cts.hackathon.tourist.service.AttractionsService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Root resource (exposed at "attractions" path)
 */
@Path("/attractions")
public class Attractions {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	AttractionsService attractionsService = new AttractionsService();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<Attraction> getAttractions() {

		return attractionsService.getAttractions();

		// return "Attractions in Mysore are -- Brindavan Garden, Mysore Palace,
		// Chamundeshwari Temple";
	}

	@POST
	@Path("/single")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getAttraction(@Context HttpServletRequest httpRequest, String json) {
		// @Context HttpServletRequest httpRequest
		System.out.println("HTTP request contains following URL" + httpRequest.getRequestURL());

//		JsonObject successMessage = new JsonParser()
//				.parse("{\"speech\": \"Places to visit in Mysore are Mysore palace, Brindavan Garden\",\"displayText\": \"Places to visit in Mysore are Mysore palace, Brindavan Garden\"}")
//				.getAsJsonObject();

		JsonObject failureMessage = new JsonParser()
				.parse("{\"speech\": \"No matching places found for the mentioned city\" ,\"displayText\": \"No matching places found for the mentioned city\"}")
				.getAsJsonObject();

		JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();

		System.out.println("HTTP request contains following body..." + jsonObj);
		
		String geoCity = "";
		try{
			 geoCity = jsonObj.getAsJsonObject("result").getAsJsonObject("parameters").get("geo-city").getAsString();
				
		}catch(NullPointerException ne){
			
			System.out.println("Null pointer exception");
			 ne.printStackTrace();
		}
		

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

		//return attractionsService.getAttraction();

		// return "Attractions in Mysore are -- Brindavan Garden, Mysore Palace,
		// Chamundeshwari Temple";
	}

}
