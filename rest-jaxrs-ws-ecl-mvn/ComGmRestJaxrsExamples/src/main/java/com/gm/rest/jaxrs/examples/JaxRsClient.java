package com.gm.rest.jaxrs.examples;

import javax.ws.rs.BeanParam;

// based on https://jersey.java.net/documentation/latest/client.html

import javax.ws.rs.client.*; // for Client, Invocation.Builder etc
import javax.ws.rs.core.Response;


public class JaxRsClient {

	public static void main(String[] args) {
		
	Client client = ClientBuilder.newClient();
	
	// get1
	//WebTarget target1 = client.target("http://localhost:8080/rest/jaxrsexample").path("get1");
	WebTarget target1 = client.target("http://localhost:8080/ComGmRestJaxrsExamples/rest/jaxrsexample").path("get1");

	// Invoke
	Invocation.Builder invocationBuilder = target1.request("text/plain").header("my-header", "gm");
	invocationBuilder.header("requestor-name", "xyz");
	Response response = invocationBuilder.get();
	
	System.out.println ("Response from - " + target1.getUri());
	System.out.println ("Return code   - " + response.getStatus());
	System.out.println ("Header        - " + response.getStringHeaders().toString());
	System.out.println ("Response body - " + response.readEntity(String.class));	
	System.out.println ("----------------------------");
	
	/*
	 * Invocation.Builder invocationBuilder =
	 * helloworldWebTargetWithQueryParam.request(MediaType.TEXT_PLAIN_TYPE);
	 * invocationBuilder.header("some-header", "true");
	 * 
	 */
	
	// get2
	WebTarget target2 = client.target("http://localhost:8080/ComGmRestJaxrsExamples/rest/jaxrsexample");
	WebTarget target2get = target2.path("get2").path("102");
	
	// Invoke
	invocationBuilder = target2get.request("text/plain").header("my-header", "gm");
	invocationBuilder.header("requestor-name", "xyz");
    response = invocationBuilder.get();
	
	System.out.println ("Response from - " + target2get.getUri());
	System.out.println ("Return code   - " + response.getStatus());
	System.out.println ("Header        - " + response.getStringHeaders().toString());
	System.out.println ("Response body - " + response.readEntity(String.class));
	System.out.println ("----------------------------");
	
	// get3
	WebTarget target3 = client.target("http://localhost:8080/ComGmRestJaxrsExamples/rest/jaxrsexample");
	WebTarget target3get = target3.path("get3").queryParam("id", "102");
	
	// Invoke
	invocationBuilder = target3get.request("text/plain").header("my-header", "gm");
	invocationBuilder.header("requestor-name", "xyz");
    response = invocationBuilder.get();
	
	System.out.println ("Response from - " + target3get.getUri());
	System.out.println ("Return code   - " + response.getStatus());
	System.out.println ("Header        - " + response.getStringHeaders().toString());
	System.out.println ("Response body - " + response.readEntity(String.class));
	System.out.println ("----------------------------");
	
	
	//get11 - beanparam
	ParamBean myParamBean = new ParamBean();
	myParamBean.setPathParam("This is the pathParam value I set in client");
	
	WebTarget target4 = client.target("http://localhost:8080/ComGmRestJaxrsExamples/rest/jaxrsexample");
	WebTarget target4get = target4.path("get11").path("pathParam-SetByClient");
	
	// Invoke
	invocationBuilder = target4get.request();
	response = invocationBuilder.get();
	
	System.out.println ("Response from - " + target4get.getUri());
	System.out.println ("Return code   - " + response.getStatus());
	System.out.println ("Header        - " + response.getStringHeaders().toString());
	System.out.println ("Response body - " + response.readEntity(String.class));
	System.out.println ("----------------------------");
	
	}

}

