package com.gm.rest.spring.ComGmSpringBoot1Jar.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//servlet response related
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

//exceptions
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class CookieController1 {

	// https://www.tutorialspoint.com/servlets/servlets-cookies-handling.htm

	@GetMapping("/cookie/setcookie/{myCookieName}")
	void setCookie(@PathVariable String myCookieName, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		// Cookie cookie1 = new Cookie("myCookieName",
		// request.getParameter(myCookieName));
		Cookie cookie1 = new Cookie("myCookieName", myCookieName);
		//cookie1.setMaxAge(1000);
		cookie1.setMaxAge(5);
		cookie1.setPath("/cookie/"); // set correct path - or "/" - without path
										// it seemed no default gets set

		response.addCookie(cookie1);
		response.setContentType("text/html");

		String title = "Setting Cookies Example";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

		PrintWriter out = response.getWriter();
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n");

		out.println(docType + "myCookieName is - " + myCookieName + " domain " + cookie1.getDomain());

	}

	// https://www.tutorialspoint.com/servlets/servlets-cookies-handling.htm

	@GetMapping("/cookie/getcookie")
	void getCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();

		String headerCookieName = request.getHeader("myCookieName");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String title = "Reading Cookies Example";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n");

		if (cookies != null) {
			out.println("<h2> Found Cookies Name and Value</h2>");

			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				out.print("Name : " + cookie.getName() + ",  ");
				out.print("Value: " + cookie.getValue() + " <br/>");
			}
		} else {
			out.println("<h2>No cookies found - " + headerCookieName + "</h2>");
		}

		out.println("</body>");
		out.println("</html>");

	}
}
