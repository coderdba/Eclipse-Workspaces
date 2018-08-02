package com.gm.rest.jaxrs.examples;


import javax.ws.rs.PathParam;

public class ParamBean {
	
	@PathParam ("pathparam1")
	//@PathParam (value="pathparam1")
	private String pathParam;
	
	public void setPathParam() {
		this.pathParam = "hardcoded-path-param";
	}
	
	public void setPathParam(String pathParamValue) {
		this.pathParam = pathParamValue;
	}
	
	public String getPathParam() {
		return pathParam;
	}
}