package com.gm.springboot.jdbc.oracle.model;

import java.util.Date;

public class Customer {

    int id;
    String name;
    String email;
    Date date;

    public Customer(int id, String name, String email, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }
    
    // for use as bean 
    public Customer() {
    	
    }

    //getters and setters and toString...
    public void setAll(int id, String name, String email, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }
}
