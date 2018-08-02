package com.gm.rest.jaxrs.examples;

import javax.ws.rs.FormParam;

public class FormParamBean {

	@FormParam ("firstName")
	private String firstName;
	
	@FormParam ("lastName")
	private String lastName;
	
	public void setFirstName(String inputFirstName) {
		this.firstName = inputFirstName;
	}
	
	public void setLastName(String inputLastName) {
		this.lastName = inputLastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
}
