package com.gm.rest.jaxrs.examples;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jaxrsexample2")
public class JaxRsExample2 {

	@GET
	@Path("/get1")
	@Produces(MediaType.TEXT_PLAIN)
	public String get1() {
		return ("In Get1 of JaxRsExample2 - this ignores all input, produces really no output except this message");
	}
}