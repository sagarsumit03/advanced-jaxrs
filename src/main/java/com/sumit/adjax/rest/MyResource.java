package com.sumit.adjax.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
@Singleton
public class MyResource {

	int count;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		count+=1;
		return "Hello World +count is "+count;
	}
}

//the scope of a resource is only till request. i.e if a request is made its destroyed.
//hence count always shows 1. everytime we refresh the page. this is default behavior

//we can have a singletone we have to annotate the resource to singleton. it will be same the 
//whole time multiple requests.
