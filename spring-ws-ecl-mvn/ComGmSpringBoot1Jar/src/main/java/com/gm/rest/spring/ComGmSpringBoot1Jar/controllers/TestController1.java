package com.gm.rest.spring.ComGmSpringBoot1Jar.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//servlet response related
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.net.URLEncoder;

//exceptions
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

//utils
import java.util.Date;

@RestController
public class TestController1 {
  
  @GetMapping("/hellome")
  String hellome() {
    return "Hello You!";
  }
  
  @GetMapping("/getme/{thing}")
  String getme(@PathVariable String thing) {
    return "Got " + thing;
  }
  
  @GetMapping("/googleitnow/{thing}")
   void googleit(@PathVariable String thing, HttpServletResponse response) throws IOException {
    response.sendRedirect("https://www.google.com/search?q=" + thing);
  }
  
  @GetMapping("/mycookie/{myCookieName}")
   void mycookie(@PathVariable String myCookieName, HttpServletRequest request, HttpServletResponse response) throws IOException {
    
	// set up http session - https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting
	HttpSession session = request.getSession();
	session.setAttribute("user", "myselfTheUser");
	session.setMaxInactiveInterval(10); // in sec, (30*60) for 30 min
	  
	// create cookies
    Cookie aCookie = new Cookie("aCookieName",myCookieName);
    aCookie.setMaxAge(10); //seconds
    
    //http://www.java2s.com/Code/Java/Servlets/Usecookietosavesessiondata.htm
    //Cookie sessionIdCookie = new Cookie("sessionId", generateSessionId());
    
    Cookie sessionIdCookie = new Cookie("sessionId", request.getSession().getId());
    sessionIdCookie.setMaxAge(10); //seconds
    
    // content type
    response.setContentType("text/html");
    
    // add cookies
    response.addCookie(aCookie);
    response.addCookie(sessionIdCookie);
    
    // headers
    response.setHeader("thisMyHeader1", "hey hey");
    response.setHeader("thisMyHeader2", "hey hey hey");
    
    // body
    //response.getWriter().write("A cookie is - " + cookiename);
    response.getWriter().write("A cookie name is - " + aCookie.getName() + ", value is - " + aCookie.getValue() + "<br>" + 
    							"Session Id Cookie name is - " + 
    							sessionIdCookie.getName() + ", value is - " + sessionIdCookie.getValue()
	+ "<br>" + "Session Id Cookie expiry seconds is - " + 
	 sessionIdCookie.getMaxAge()
	+ "<br>" + "A Cookie expiry seconds is - " + aCookie.getMaxAge())
    ;	   			
    		 
    response.getWriter().flush();
    response.getWriter().close();
    
  }
  
  @GetMapping("/requestresponse")
  void mycookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
   
	// set up http session - https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting
	HttpSession session = request.getSession();
	session.setMaxInactiveInterval(10); // in sec, (30*60) for 30 min

	Cookie[] requestCookies  = request.getCookies();
	
   // RESPONSE
   // content type
   response.setContentType("text/html");
  
   // headers
   response.setHeader("thisMyHeader1", "hey hey");
   response.setHeader("thisMyHeader2", "hey hey hey");
   
   // body
   Date date = new Date();
   PrintWriter responseBody;
   responseBody = response.getWriter();
   responseBody.write("Now Time is " + date + "<br>");
   
   // response.getWriter().write("Now Time is " + date);   	
   for (int i = 0; i < requestCookies.length; i++) {
		String name = requestCookies[i].getName();
		String value = requestCookies[i].getValue();
		
		responseBody.write("Request Cookie: " + name + ", Value: " + value + "<br>");
		//System.out.println("cookie: " + name + ":" + value);
   }  
   response.getWriter().flush();
   response.getWriter().close();
   
 }
  
  @GetMapping("/responsecookie")
  void responsecookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
   //https://www.tutorialspoint.com/servlets/servlets-cookies-handling.htm
	
	// set up http session - https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting
	HttpSession session = request.getSession();
	// dont set a timeout for session yet
	//session.setMaxInactiveInterval(10); // in sec, (30*60) for 30 min
	
   // RESPONSE
   // content type
   response.setContentType("text/html");
   
   // body
   Date date = new Date();
   PrintWriter responseBody;
   responseBody = response.getWriter();
   responseBody.write("Now Time is for responsecookie - " + date + "<br>");
   
   // Create cookies for first and last names.      
   //Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
   //Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));
   Cookie firstName = new Cookie("first_name", "raja");
   Cookie lastName = new Cookie("last_name", "ram");
   
   // Set expiry date after 24 Hrs for both the cookies.
   //firstName.setMaxAge(60*60*24);
   //lastName.setMaxAge(60*60*24);
   firstName.setMaxAge(5);
   lastName.setMaxAge(5);

   // Add both the cookies in the response header.
   response.addCookie( firstName );
   response.addCookie( lastName );
   
   response.getWriter().flush();
   response.getWriter().close();
   
 } 
  
  
  // http://www.java2s.com/Code/Java/Servlets/Usecookietosavesessiondata.htm
  private static String generateSessionId() throws UnsupportedEncodingException {
	    String uid = new java.rmi.server.UID().toString(); // guaranteed unique
	    return URLEncoder.encode(uid,"UTF-8"); // encode any special chars
	  }
  
}