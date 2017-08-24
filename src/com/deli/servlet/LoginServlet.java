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

		
		System.out.println("--- In the doPost --");
		
		context = getServletContext();
		String homeURI = request.getContextPath() + "/secured/index.jsp";
		// get request parameters for userID and password
		String pass = request.getParameter("j_username");
	//	String username = request.getParameter("username");
	//	String password = request.getParameter("password");

		if (pass.equals("123456")) {
			System.out.println(" - granted access !");
		} else {
			System.out.println(" - access Refused");
			pass = null;
		}

		// User user = userDAO.find(username, password);

		System.out.println(" - entered password is " + pass);

		if (pass != null) {

			request.setAttribute("message", "Welcome to your page !");
			request.setAttribute("titleMessage", pass);

			request.getSession().setAttribute("user", pass); // Put user in
																// session.
			System.out.println("redirect to " + homeURI);
			response.sendRedirect(homeURI); // Go to some start page.
			return;
		} else {
			request.setAttribute("error", "Unknown login, try again"); // Set
																		// error
																		// msg
																		// for
																		// ${error}
			request.getRequestDispatcher("/login.jsp").forward(request, response); // Go
																					// back
																					// to
																					// login
																					// page.
		}

	}

}
