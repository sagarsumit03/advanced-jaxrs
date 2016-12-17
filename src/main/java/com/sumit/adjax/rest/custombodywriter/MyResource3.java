package com.sumit.adjax.rest.custombodywriter;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date1")
public class MyResource3 {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date testMethod() {
		return Calendar.getInstance().getTime();
	}
}

// this Method will give 500 error as jersey will say no message body writer is
// found
// can't convert from date to text_plain string