package com.cts.hackathon.tourist.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<Attraction> getAttractions() {
		

		return attractionsService.getAttractions();
		
		//return "Attractions in Mysore are -- Brindavan Garden, Mysore Palace, Chamundeshwari Temple";
	}
	
	@POST
	@Path("/single")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Attraction getAttraction( @Context HttpServletRequest httpRequest, String json) {
		//@Context HttpServletRequest httpRequest
		System.out.println("HTTP request contains following URL" + httpRequest.getRequestURL());
		System.out.println("HTTP request contains following body..." + json);
		
		return attractionsService.getAttraction();
		
		//return "Attractions in Mysore are -- Brindavan Garden, Mysore Palace, Chamundeshwari Temple";
	}

}
