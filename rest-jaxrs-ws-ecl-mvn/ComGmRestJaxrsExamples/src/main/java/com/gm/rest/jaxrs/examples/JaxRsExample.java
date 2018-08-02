package com.gm.rest.jaxrs.examples;

// based on http://java.boot.by/ocewsd6-guide/ch02.html

import java.io.*;
import java.net.URI;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.BeanParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;

import javax.servlet.http.HttpServletResponse;

@Path("/jaxrsexample")
public class JaxRsExample {

	// @Context
	// private HttpServletResponse response;

	@Context
	UriInfo uriInfo;

	@GET
	@Path("/get1")
	@Produces(MediaType.TEXT_PLAIN)
	public String get1() {
		return ("In Get1 - this ignores all input, produces really no output except this message");
	}

	@GET
	@Path("/get2/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String get2(@PathParam("id") int id) {
		return ("In Get2 - input PathParam is " + id);
	}

	@GET
	@Path("/get3")
	@Produces(MediaType.TEXT_PLAIN)
	// Usage /get3?id=10&name=somename
	public String get3(@QueryParam("id") int id, @QueryParam("name") String name) {
		return ("In Get3 - input QueryParam is " + id + "-" + name);
	}

	@GET
	@Path("/get4")
	@Produces(MediaType.TEXT_HTML)
	// Usage /get4?id=10&name=somename
	public String get4(@Context HttpServletResponse response, @QueryParam("id") int id,
			@QueryParam("name") String name) {

		response.setContentType("text/html");
		response.setHeader("Refresh", "300");

		return ("<b>In Get4 - Http response with header " + id + " - " + name);
	}

	@GET
	@Path("/get5")
	@Produces(MediaType.TEXT_HTML)
	// Usage /get4?id=10&name=somename
	public void get5(@Context HttpServletResponse response, @QueryParam("id") int id, @QueryParam("name") String name)
			throws Exception {

		response.setContentType("text/html");
		response.setHeader("Refresh", "300");

		PrintWriter responseBody = response.getWriter();
		responseBody.print("<b>In Get5 - Http response with header and body " + id + " - " + name);
		responseBody.close();

		// return ("<b>In Get5 - Http response with header and body " + id + " -
		// " + name);
	}

	@Path("/get6")
	@GET
	public String get6(@Context UriInfo uriInfo) {

		// Client used this URI to reach this resource method
		return ("In get6 - showing URI of this request using UriInfo - " + uriInfo.getAbsolutePath().toASCIIString());
	}

	@Path("/get7")
	@GET
	public String get7() {

		// Client used this URI to reach this resource method
		return ("In get7 - showing URI of this request using UriInfo - " + uriInfo.getAbsolutePath().toASCIIString());
	}

	@Path("/get8")
	@GET
	public String get8() {
		// builds a path adding relative uri to the method-URI's absolute path
		UriBuilder ub = uriInfo.getAbsolutePathBuilder();
		URI newUri = ub.path("addedThis").build();

		return ("In get8 - showing URI of this request with appended path - " + newUri.toASCIIString());
	}

	@Path("/get9")
	@GET
	@Produces("text/plain")
	public String get9() {
		// extracts query-params from the URL and displays the keys (not values)
		StringBuilder buf = new StringBuilder();

		buf.append("Parameter Names: \n");

		for (String param : uriInfo.getQueryParameters().keySet()) {
			buf.append(param);
			buf.append("\n");
		}

		return buf.toString();
	}

	@GET
	@Path("/get10/{id}")
	public Response get10(@PathParam("id") int id) {

		Date expirationDate = new Date(System.currentTimeMillis() + 3000); // 3
																			// secs
		// return ("In Get10 - input PathParam is " + id);

		// set an expiration in the header of the response
		return Response.status(Response.Status.OK).entity("Id: " + id).expires(expirationDate).build();
	}

	@GET
	@Path("/get11/{pathparam1}")
	@Produces(MediaType.TEXT_PLAIN)
	public String get11(@BeanParam ParamBean beanParam, String entity) {
		// System.out.println ("In get11 - pathParam - " +
		// beanParam.getPathParam());
		return ("In get11 - " + beanParam.getPathParam());
	}
	
	@POST // FormParam does not work for GET
	@Path("/post1")
	//@Consumes("application/x­www­form­urlencoded") // not needed
	@Produces(MediaType.TEXT_HTML)
	public String post1(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName) {
		
		return ("Your name is - " + firstName + " " + lastName);
	}
	
	@POST // FormParam based bean - does not work for GET
	@Path("/post2")
	@Produces(MediaType.TEXT_PLAIN)
	public String post2(@BeanParam FormParamBean beanParam) {
		return ("In post2 - your name is - " + beanParam.getFirstName() + " " + beanParam.getLastName());
	}
	
	@POST // FormParam based bean - does not work for GET
	@Path("/post3")
	@Produces(MediaType.TEXT_PLAIN)
	public Response post3(@BeanParam FormParamBean beanParam) {
		
		System.out.println("In post3 - your name is - " + beanParam.getFirstName() + " " + beanParam.getLastName());		
		return Response.ok().status(200).entity(beanParam).build();
	}
	
	/*
	 * @GET
	 * 
	 * @Path("/get99") public Viewable get99() { return new Viewable
	 * ("index.html", "something in it"); }
	 */
}
