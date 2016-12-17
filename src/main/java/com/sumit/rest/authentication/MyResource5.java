package com.sumit.rest.authentication;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class MyResource5 {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "Hello we got Authenticated";
	}
}