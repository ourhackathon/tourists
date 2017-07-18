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

		

		JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();

		System.out.println("HTTP request contains following body..." + jsonObj);
		
		String geoCity = "";
		try{
			 geoCity = jsonObj.getAsJsonObject("result").getAsJsonObject("parameters").get("geo-city").getAsString();
				
		}catch(NullPointerException ne){
			
			System.out.println("Null pointer exception");
			 ne.printStackTrace();
		}
		

		return attractionsService.getAttraction(geoCity);

		// return "Attractions in Mysore are -- Brindavan Garden, Mysore Palace,
		// Chamundeshwari Temple";
	}

}
