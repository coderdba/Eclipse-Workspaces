package com.gm.springboot.jdbc.oracle.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataModelBeans {
	
    @Bean
    public Customer customerBean() {
        return new Customer();
    }
}
 
