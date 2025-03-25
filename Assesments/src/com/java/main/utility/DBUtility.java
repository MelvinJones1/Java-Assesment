package com.java.main.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtility {
	static DBUtility dbUtil;
	 
	 static {
		 dbUtil= new DBUtility();
	 }
	 
	public  static DBUtility getInstance() {
		 return dbUtil;
	 }

	private final String userDb="root";
	private final String dbPass="melvin@sql";
	private final String url="jdbc:mysql://localhost:3306/assesment";
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private Connection con; 
	
	
	public Connection dbConnect() {
		/*Step 1: Load the driver */
		try {
			Class.forName(driver);
			//System.out.println("DRIVER LOADED!!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOADING FAILED!!!!");
		}
		/* Step 2: Establish connection */
		try {
			con = DriverManager.getConnection(url, userDb, dbPass);
			//System.out.println("CONNECTION ESTABLISHED...");
		} catch (SQLException e) {
			System.out.println("CONNECTION iSSUE...");
		}
		
		return con; 
	}
	
	public void dbClose() {
		/* Close the connection*/
		try {
			con.close();
			//System.out.println("connection closed...");
		} catch (SQLException e) {
			 System.out.println(e.getMessage());	
		}
	}
}
