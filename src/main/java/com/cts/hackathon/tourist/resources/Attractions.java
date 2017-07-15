package com.cts.hackathon.tourist.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cts.hackathon.tourist.model.Attraction;
import com.cts.hackathon.tourist.service.AttractionsService;

/**
 * Root resource (exposed at "attractions" path)
 */
@Path("/attractions")
public class Attractions {

	 /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	AttractionsService attractionsService = new AttractionsService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Attraction> getAttractions() {
		

		return attractionsService.getAttractions();
		
		//return "Attractions in Mysore are -- Brindavan Garden, Mysore Palace, Chamundeshwari Temple";
	}

}
