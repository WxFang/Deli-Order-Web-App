package com.deli.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.deli.util.*;
import com.deli.entity.*;
import com.deli.entity.*;

/**
 * Servlet implementation class OrderControllerServlet
 */
@WebServlet("/OrderControllerServlet")
public class OrderControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DishDbUtil DishDbUtil;
	
	@Resource(name="jdbc/webdeli")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our dish dbutil ...  and pass in the connection pool
		try{
			DishDbUtil = new DishDbUtil(dataSource);
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("... get in serlet");
		try{
			
			listDishes(req, resp);
		}
		catch(Exception e){
			throw new ServletException(e);
		}
	}

	private void listDishes(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		List<Dish> dishes = DishDbUtil.getDishes();
		System.out.println(dishes.size());
		
		request.setAttribute("DISH_LIST", dishes);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(request, response);
	}

}
