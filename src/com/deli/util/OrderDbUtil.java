package com.deli.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.deli.entity.*;

public class OrderDbUtil {

	
	private DataSource dataSource;

	public OrderDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Order> getOrders() throws Exception{
		List<Order> orders = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myConn = dataSource.getConnection();
			
			String sql = "select * from `order` order by dishId";
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()){
				String userName = myRs.getString("userName");
				String dishName = myRs.getString("dishName");
				int dishId = myRs.getInt("dishId");
				String email = myRs.getString("email");
				String cell = myRs.getString("cell");
				String time = myRs.getString("time");
				String place = myRs.getString("place");
				int price = myRs.getInt("price");
				String payment = myRs.getString("payment");
				boolean isPaid = myRs.getBoolean("isPaid");
				boolean isPicked = myRs.getBoolean("isPicked");
				String note = myRs.getString("note");
				
				Order tempOrder = new Order(userName, dishName, dishId, email, cell, time, place, price,
						payment, isPaid, isPicked, note);
				
				orders.add(tempOrder);
			}
			
			return orders;
		}
		finally{
			
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
			if(myRs != null)
				myRs.close();
			if(myStmt != null)
				myStmt.close();
			
			// doesnt really close it
			// just put back to connection pool
			
			if(myConn != null)
				myConn.close();
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}

	public void addOrder(Order theOrder) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
			myConn = dataSource.getConnection();
			String sql = "insert into `order` "
					+ "(userName, dishName, dishId, email, cell, time, place, price, payment, isPaid, isPicked, note) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theOrder.getUserName());
			myStmt.setString(2, theOrder.getDishName());
			myStmt.setInt(3, theOrder.getDishId());
			myStmt.setString(4, theOrder.getEmail());
			myStmt.setString(5, theOrder.getCell());
			myStmt.setString(6, theOrder.getTime());
			myStmt.setString(7, theOrder.getPlace());
			myStmt.setInt(8, theOrder.getPrice());
			myStmt.setString(9, theOrder.getPayment());
			myStmt.setBoolean(10, theOrder.isPaid());
			myStmt.setBoolean(11, theOrder.isPicked());
			myStmt.setString(12, theOrder.getNote());
			
			try{
				myStmt.execute();
			}
			catch(Exception exc){
				System.out.println("cannot add new order into order");
			}
			
			
		}
		finally{
			close(myConn, myStmt, null);
		}
	}
}



