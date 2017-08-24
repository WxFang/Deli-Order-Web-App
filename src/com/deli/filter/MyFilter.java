package com.deli.filter;




import java.io.IOException;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


   
public class MyFilter implements Filter{  

	private ServletContext context;
	
	
public void init(FilterConfig arg0) throws ServletException {
	context = arg0.getServletContext();
}  


public void doFilter(ServletRequest req, ServletResponse res,  
	    FilterChain chain) throws IOException, ServletException { 
	
	
	System.out.println("--- in the doFilter ---");
	
	HttpServletRequest request = (HttpServletRequest) req;
	HttpServletResponse response = (HttpServletResponse) res;
	HttpSession session = request.getSession(false);
	String loginURI = request.getContextPath() + "/login.jsp";
	System.out.println(" - login uri :"+loginURI);
	System.out.println(" - Context : "+context);

	boolean loggedIn = session != null && session.getAttribute("user") != null;
	boolean loginRequest = request.getRequestURI().equals(loginURI);

	if (loggedIn || loginRequest) {

		System.out.println(request.getRequestURI());

	    chain.doFilter(request, response); // User is logged in, just continue request.
	    
	} else {
		System.out.println("in the else");
	    response.sendRedirect(loginURI); // Not logged in, show login page.
	}
 


}


      
	/**
	 * This destroy method is going to shutdown the access to the database, before destoying the servlet.
	 */
    public void destroy() {
    	
    	//Database.shutdown();
    	
    }  
    
    


}
