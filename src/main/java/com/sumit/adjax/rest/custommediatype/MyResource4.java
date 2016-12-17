package com.sumit.adjax.rest.custommediatype;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("date2")
public class MyResource4 {

	@GET
	@Produces("text/shortdate")
	public Date testMethod() {
		return Calendar.getInstance().getTime();
	}
}

//for having a custom MediaTYpe example- "text/shortdate"
// we have to have a MessageBodyWriter for the above mediatype and 
//we annotate the writer class with the custom media type. with @produces("text/shortdate")
