package com.gm.oracle.services;

import java.io.IOException;
import java.util.List;

//import javax.servlet.http.HttpServletResponse; // not required
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.gm.oracle.datahandlers.DbConnOracle;

@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();

	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";
	private String password;

    @GET
    @Path("/isup")
    @Produces("application/json")
    public String getResponse()
    {
        System.out.println("UserService is up");
        		
        String response = "UserService is up";
        return response;
    }
	
	// UPDATE USER PASSWORD WITH JSON INPUT
	@POST
	@Path("/users/resetpw")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	//@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
	public String resetUserPasswordJson(User user) throws Exception {
		try {
			
			System.out.println ("\n\nINFO - in UserService - user:" + user.getId() + " host: " +
									user.getDbScanOrHost() + " DB: " + user.getDbServiceOrSID() + "\n");
			
			password = userDao.resetPasswordOra(user);
			
		} catch (Exception e) {
			
			System.out.println ("\n ERR - in UserService - Error in connecting or executing in database\n");
			e.printStackTrace();
			
			return "\nERR - Your new password IS NOT RESET - \n could not connect to database OR complete database operation \n";
		}
		
		return "\nYour new password is : " + password + "\n";			
	}
	
	// UPDATE USER PASSWORD WITH URL ENCODED INPUT
	@POST
	@Path("/users/resetpwurl")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String resetUserPasswordFormURL(@FormParam("id") String id, 
			@FormParam("dbServiceOrSID") String dbServiceOrSID,
			@FormParam("dbScanOrHost") String dbScanOrHost,
			@FormParam("port") String port) throws Exception {
		
		//User user = new User(id, dbServiceOrSID, dbScanOrHost, port);
		User user = new User();
		user.setId(id);
		user.setDbServiceOrSID(dbServiceOrSID);
		user.setDbScanOrHost(dbScanOrHost);
		user.setPort(port);
		
		try {
			
			System.out.println ("\n\nINFO - in UserService - user:" + user.getId() + " host: " +
									user.getDbScanOrHost() + " DB: " + user.getDbServiceOrSID() + "\n");
			
			password = userDao.resetPasswordOra(user);
			
		} catch (Exception e) {
			
			System.out.println ("\n ERR - in UserService - Error in connecting or executing in database\n");
			e.printStackTrace();
			
			return "\nERR - Your new password IS NOT RESET - \n could not connect to database OR complete database operation \n";
		}
		
		return "\nYour new password is : " + password + "\n";			
	}
	
	// UPDATE USER PASSWORD WITH URL ENCODED INPUT
	@POST
	@Path("/users/resetpwpath/{id}/{dbServiceOrSID}/{dbScanOrHost}/{port}")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String resetUserPasswordFormPath(@PathParam("id") String id, 
			@PathParam("dbServiceOrSID") String dbServiceOrSID,
			@PathParam("dbScanOrHost") String dbScanOrHost,
			@PathParam("port") String port) throws Exception {
		
		//User user = new User(id, dbServiceOrSID, dbScanOrHost, port);
		User user = new User();
		user.setId(id);
		user.setDbServiceOrSID(dbServiceOrSID);
		user.setDbScanOrHost(dbScanOrHost);
		user.setPort(port);
		
		try {
			
			System.out.println ("\n\nINFO - in UserService - user:" + user.getId() + " host: " +
									user.getDbScanOrHost() + " DB: " + user.getDbServiceOrSID() + "\n");
			
			password = userDao.resetPasswordOra(user);
			
		} catch (Exception e) {
			
			System.out.println ("\n ERR - in UserService - Error in connecting or executing in database\n");
			e.printStackTrace();
			
			return "\nERR - Your new password IS NOT RESET - \n could not connect to database OR complete database operation \n";
		}
		
		return "\nYour new password is : " + password + "\n";			
	}
	
	// UNLOCK USER WITH JSON INPUT
	@POST
	@Path("/users/unlock")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public String unlockUserJson(User user) {
		try {
			
			System.out.println ("\n\nINFO - Unlocking user account in UserService - user:" + user.getId() + 
									" host: " +	user.getDbScanOrHost() + " DB: " + user.getDbServiceOrSID() + "\n");
			
			userDao.unlockUserOra(user);
			
		} catch (Exception e) {
			
			System.out.println ("\n\nERR - Error in unlocking user account in UserService - user:" + user.getId() + 
								" host: " +	user.getDbScanOrHost() + " DB: " + user.getDbServiceOrSID() + "\n");		
			e.printStackTrace();
			
			return "\nERR - Your account unlock FAILED - \n "
					+ "could not connect to database OR complete database operation \n";
		}
		
		return "\nYour account unlocked\n";

	}
	
}

