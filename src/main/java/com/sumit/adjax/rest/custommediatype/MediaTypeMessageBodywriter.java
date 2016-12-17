package com.sumit.adjax.rest.custommediatype;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
/*
 * we need to specify how many mime types this class can write to, text_plain
 * etc hence we use produces anno anotation
 */
@Produces("text/shortdate")
public class MediaTypeMessageBodywriter implements MessageBodyWriter<Date> {

	@Override
	public boolean isWriteable(Class<?> classType, Type arg1, Annotation[] arg2, MediaType arg3) {
		return Date.class.isAssignableFrom(classType);
		// this checks if the above provider can convert the Date or not.
		// Instead of date we can have our own custom classes
	}

	@Override
	public long getSize(Date arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeTo(Date date/* the class we need to convert */, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream out)
			throws IOException, WebApplicationException {
		// this method takes that first argument i.e date and convert it into
		// outputStream.
		String s = date.getDate() + " " + date.getMonth() + " " + date.getYear();
		out.write(s.getBytes());

	}

}
