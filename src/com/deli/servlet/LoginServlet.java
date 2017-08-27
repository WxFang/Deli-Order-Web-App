package com.deli.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.crypto.BadPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletContext context;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		context = getServletContext();
		String homeURI = "secured/AdminControllerServlet";
		String pass = request.getParameter("j_username");

		if (!pass.equals("123456"))
			pass = null;

		if (pass != null) {

			request.setAttribute("message", "Welcome to your page !");
			request.setAttribute("titleMessage", pass);

			request.getSession().setAttribute("user", pass);
			System.out.println("redirect to " + homeURI);
			response.sendRedirect(homeURI); 
			return;
		} else {
			request.setAttribute("error", "Unknown login, try again"); 
			request.getRequestDispatcher("/login.jsp").forward(request, response); 
		}

	}

}
