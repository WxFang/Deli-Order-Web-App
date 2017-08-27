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
 * Servlet implementation class AdminControllerServet
 */
@WebServlet("/secured/AdminControllerServlet")
public class AdminControllerServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderDbUtil OrderDbUtil;
	
	private DishDbUtil DishDbUtil;
	
	@Resource(name="jdbc/webdeli")
	private DataSource dataSource;
	
	public void init(ServletConfig config) throws ServletException {
		super.init();
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
			if(theCommand == null)
				theCommand = "LIST";
			switch(theCommand){
			
			case "LIST":
				listOrdersDishes(request, response);
				break;
			
			case "ADD":
				addDish(request, response);
				break;
				
			case "DELETE":
				deleteDish(request, response);
				break;
				
			case "LOAD":
				loadDish(request, response);
				break;
				
			case "UPDATE":
				updateDish(request, response);
				break;
					
			case "PAID":
				paidOrder(request, response);
				break;
				
			case "PICKED":
				pickedOrder(request, response);
				break;
				
			default: 
				listOrdersDishes(request, response);
			}
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}
	}

	private void pickedOrder(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		String dishName = request.getParameter("dishName");
		String email = request.getParameter("email");
		OrderDbUtil.pickedOrder(dishName, email);
		listOrdersDishes(request, response);
	}


	private void paidOrder(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		String dishName = request.getParameter("dishName");
		String email = request.getParameter("email");
		OrderDbUtil.paidOrder(dishName, email);
		listOrdersDishes(request, response);
	}


	
	
	private void updateDish(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		String dishName = request.getParameter("dishName");
		int dishId = Integer.parseInt(request.getParameter("dishId"));
		int price = Integer.parseInt(request.getParameter("price"));
		Dish theDish = new Dish(dishId, dishName, price);
		DishDbUtil.updateDish(theDish);
		listOrdersDishes(request, response);
		
	}


	private void loadDish(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		String dishName = request.getParameter("dishName");
		
		Dish theDish = DishDbUtil.getDish(dishName);
		
		request.setAttribute("THE_DISH", theDish);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/secured/update-dish.jsp");
		dispatcher.forward(request, response);
	}


	private void listOrdersDishes(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			String sql = request.getParameter("sql");
			List<Order> orders = OrderDbUtil.getOrders(sql);
			List<Dish> dishes = DishDbUtil.getDishes();
			request.setAttribute("DISH_LIST", dishes);
			request.setAttribute("ORDER_LIST", orders);
			request.getRequestDispatcher("/secured/index.jsp").forward(request, response);
		}
	
	private void addDish(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			String dishName = request.getParameter("dishName");
			int price = Integer.parseInt(request.getParameter("price"));
			
			Dish theDish = new Dish(dishName, price);
			DishDbUtil.addDish(theDish);
			
			listOrdersDishes(request, response);
		}

	private void deleteDish(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			int dishId = Integer.parseInt(request.getParameter("dishId"));
			int price = Integer.parseInt(request.getParameter("price"));
			String dishName = request.getParameter("dishName");
			Dish theDish = new Dish(dishId, dishName, price);
			DishDbUtil.deleteDish(theDish);
			
			listOrdersDishes(request, response);
		}
}
