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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try{
	        	
	            String id = request.getParameter("id");
	            String password = request.getParameter("password");
	            
	            String ctxPath = request.getContextPath();
	            
	            String indexPage = "/admin/list_orders.jsp";
	            PrintWriter out  = response.getWriter();
	            
	            if(id == "root" && password == "12345678") {
	            	
	            	// create cookie
	                request.getSession().setAttribute("adminId", id);
	                request.getSession().setAttribute("adminPsw", password);
	                
	                // set cookie
	                URLEncoder.encode("Name","UTF-8");
	                Cookie Id =new Cookie("adminId", id);
	                Cookie Pass = new Cookie("adminPsw", password);
	                response.addCookie(Id);
	                response.addCookie(Pass);
	                
	                request.getSession().setAttribute("admin", "root");
	                // redirect to list_orders page 
	                response.sendRedirect(ctxPath+indexPage);
	            } else {
	            	System.out.println("User doesn't exist or wrong password");
	            	response.sendRedirect(ctxPath+"/welcome.jsp");
	            }
	        } catch (Exception exc){
	            exc.printStackTrace();
	        }
	}

}
