package com.deli.util;

import javax.sql.DataSource;

import com.deli.entity.Dish;

import java.sql.*;
import java.util.*;

public class DishDbUtil {
	
	private DataSource dataSource;

	public DishDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Dish> getDishes() throws Exception{
		System.out.println("... get in database");
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
			
			return dishes;
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

}
