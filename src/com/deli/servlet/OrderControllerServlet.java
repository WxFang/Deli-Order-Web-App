package com.deli.servlet;

import com.deli.entity.*;
import com.deli.util.*;

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

/**
 * Servlet implementation class OrderControllerServlet
 */
@WebServlet("/OrderControllerServlet")
public class OrderControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderDbUtil OrderDbUtil;
	
	private DishDbUtil DishDbUtil;
	
	@Resource(name="jdbc/webdeli")
	private DataSource dataSource;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init();
		// create our dish dbutil ...  and pass in the connection pool
		try{
			OrderDbUtil = new OrderDbUtil(dataSource);
			DishDbUtil = new DishDbUtil(dataSource);
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String theCommand = request.getParameter("command");
			switch(theCommand){
			
			case "ADD":
				addOrder(request, response);
				break;
			}
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}
	}

	private void addOrder(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		
		String dishName = request.getParameter("dishName");
		String time = request.getParameter("time");
		String place = request.getParameter("place");
		String payment = request.getParameter("payment");
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String cell = request.getParameter("cell");
		String note = request.getParameter("note");
		
		Dish theDish = DishDbUtil.getDish(dishName);
		int dishId = theDish.getDishId();
		int price = theDish.getPrice();
		
		Order theOrder = new Order(userName, dishName, dishId, email, cell, time, place, price,
				payment, false, false, note);
		OrderDbUtil.addOrder(theOrder);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

}
