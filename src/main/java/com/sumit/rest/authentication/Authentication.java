package com.sumit.rest.authentication;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

/*
 * https://www.youtube.com/watch?v=W5jm4E0TTlA&index=24&list=PLqq-6Pq4lTTY40IcG584ynNqibMc1heIa
 */
@Provider
public class Authentication implements ContainerRequestFilter {
	final static String AUTHORIZATION_HEADER_KEY = "Authorization";
	final static String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	final static String SECURED_URI_PREFIX = "secured";

	// this will make all the URIs to get authenticated with the below secure
	// filter
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURED_URI_PREFIX)) {
			java.util.List<String> headerValue = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if (headerValue != null && headerValue.size() > 0) {
				String authToken = headerValue.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(authToken, ":");
				String userName = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				if ("user".equals(userName) && "password".equals(password)) {
					return;
				}
				Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
						.entity("User can't access the resource").build();
				requestContext.abortWith(unauthorizedStatus);
			}
		}
	}

}
