package com.sumit.adjax.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathparam}/hello1")
public class MyResource2 {

	@PathParam("pathparam") String pathParamExample;
	@QueryParam("query") String queryParamExample;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "Hello World & path param used is "+pathParamExample +" & query Param is "+queryParamExample;
	}
}

// The path param maps a variable to a path pattern
//http://localhost:8080/advanced-jaxrs/webapi/value/hello1?query=queryValue
//use this link to check above code.

//this has advantage over the method path and query param as these variables can be accessed over 
//different methods.
//for param value and query value we shouldn't have a singleton class  else it will throw error.
//as singleton is created before the request.
//we can only have pathparam or queryparam in methods and not as variables for singleton
