package com.deli.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// route to the appropriate method
			switch(theCommand){
			
			case "LOGIN": 
				check(request, response);
				break;
			}
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}
	}

	private void check(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		String id = request.getParameter("id");
		String psd = request.getParameter("password");
		System.out.println(id + " " + psd);
		String ctxPath = request.getContextPath();
        String indexPage = "/list_orders.jsp";
        PrintWriter out  = response.getWriter();
        
		if(id.equals("root") && psd.equals("123456")){
			// create cookie
            request.getSession().setAttribute("adminId", id);
            request.getSession().setAttribute("adminPsw", psd);
            
            // set cookie
            URLEncoder.encode("Name","UTF-8");
            Cookie Id =new Cookie("adminId", id);
            Cookie Pass = new Cookie("adminPsw", psd);
            response.addCookie(Id);
            response.addCookie(Pass);
            
            request.getSession().setAttribute("admin", "root");
            // redirect to list_orders page 
            response.sendRedirect(ctxPath+indexPage);
		}
		else{
			System.out.println("User doesn't exist or wrong password");
        	response.sendRedirect(ctxPath+"/welcome.jsp");}
		}
	}
