package com.gm.rest.spring.oracle1;

import java.io.Serializable;

public class SchemaResponse  implements Serializable {
	
	private String schemaName;
	private String schemaAction;
	private int retcode;
	private String message;
	
    public String getSchemaName() {
        return schemaName;
    }
    
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
    
    public String getSchemaAction() {
        return schemaAction;
    }
    
    public void setSchemaAction(String schemaAction) {
        this.schemaAction = schemaAction;
    }
    
    public int getRetcode() {
        return retcode;
    }
    
    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}