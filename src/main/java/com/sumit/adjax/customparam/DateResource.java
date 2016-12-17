package com.sumit.adjax.customparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateString}")
public class DateResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestDate(@PathParam("dateString") MyDate date) {
		// as the param value is not a String its MyDAte class jersey looks for a registered Converter 
		//provider to get the correct conversion.
		
		//then the MyDAteConverterProvider is called
		return "got " + date;
	}
}
