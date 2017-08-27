package com.deli.util;

import javax.sql.DataSource;

import com.deli.entity.Dish;

import java.sql.*;
import java.util.*;

public class DishDbUtil {
	
	private static DataSource dataSource;
	
	private static int maxDish = 0;

	public DishDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public static List<Dish> getDishes() throws Exception{
		List<Dish> dishes = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myConn = dataSource.getConnection();
			
			String sql = "select * from dish order by id";
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()){
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				int price = myRs.getInt("price");
				
				Dish tempDish = new Dish(id, name, price);
				
				dishes.add(tempDish);
			}
			maxDish = Math.max(maxDish, dishes.size());
			return dishes;
		}
		finally{
			
			close(myConn, myStmt, myRs);
		}
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
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

	public static Dish getDish(String dishName) 
		throws Exception {
		Dish theDish = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myConn = dataSource.getConnection();
			String sql = "select * from dish where name=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, dishName);
			myRs = myStmt.executeQuery();
			if(myRs.next()){
				int id = myRs.getInt("id");
				int price = myRs.getInt("price");
				theDish = new Dish(id, dishName, price);
				System.out.println("Have found dish name: " + dishName);
			}
			else{
				throw new Exception("Could not find dish name: " + dishName);
			}
			return theDish;
		}
		finally{
			close(myConn, myStmt, myRs);
		}
	}

	public void addDish(Dish theDish) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
			myConn = dataSource.getConnection();
			
			String sql = "insert into dish "
					+ "(name, id, price) "
					+ "values(?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theDish.getDishName());
			myStmt.setInt(2, maxDish + 1);
			maxDish++;
			myStmt.setInt(3, theDish.getPrice());
			
			myStmt.execute();
			
		}
		finally{
			close(myConn, myStmt, null);
		}
		
	}


	public void deleteDish(Dish theDish) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try{
			myConn = dataSource.getConnection();
			String sql = "delete from dish where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, theDish.getDishId());
			myStmt.execute();
		}
		finally{
			close(myConn, myStmt, myRs);
		}
	}

	public void updateDish(Dish theDish) 
		throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
			
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement 
			String sql = "update dish "
					+ "set name=?, id=?, price=? "
					+ "where name=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theDish.getDishName());
			myStmt.setInt(2, theDish.getDishId());
			myStmt.setInt(3, theDish.getPrice());
			myStmt.setString(4, theDish.getDishName());
			
			// execute SQL statement
			myStmt.execute();
		
		}
		finally{
			// clean up JDBC object
			close(myConn, myStmt, null);
		}
	}



}




