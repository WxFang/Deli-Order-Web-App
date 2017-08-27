package com.deli.servlet;

import com.deli.entity.*;
import com.deli.util.*;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DishControllerServlet
 */
@WebServlet("/DishControllerServlet")
public class DishControllerServlet extends HttpServlet {
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
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String theCommand = request.getParameter("command");
			
			if(theCommand == null)
				theCommand = "LIST";
			
			switch(theCommand){
			
			case "LIST":
				listDishes(request, response);
				break;
			
//			case "ADD":
//				addDish(request, response);
//				break;
				
			default: 
				listDishes(request, response);
			}
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}
		
		
		
		
	}


//	private void addDish(HttpServletRequest request, HttpServletResponse response) {
//		String dishName = request.getParameter("name");
//		int dishId = request.getParameter("id");
//		int price = request.getParameter("price");
//		
//		Dish theDish = new Dish(dishId, dishName, price);
//		DishDbUtil.addDish(theDish);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/order_submited.jsp");
//		dispatcher.forward(request, request);
//	}


	private void listDishes(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		List<Dish> dishes = DishDbUtil.getDishes();
		
		request.setAttribute("DISH_LIST", dishes);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(request, response);
	}

}





