package com.java.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.main.model.Customer;
import com.java.main.utility.DBUtility;

public class CustomerRepository {
	
	

	public void addCustomerWithAddress(Customer customer) {
		// TODO Auto-generated method stub
		
Connection con = DBUtility.getInstance().dbConnect();
		
		String query = "insert into customer values(?,?,?,?)";
		String query2 = "insert into address values(?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
						
			pstmt.setInt(1,customer.getId());
			pstmt.setString(2,customer.getName());
			pstmt.setString(3,customer.getContact());
			pstmt.setInt(4,customer.getAddress().getId());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(query2);
			pstmt.setInt(1,customer.getAddress().getId());
			pstmt.setString(2,customer.getAddress().getCity());
			pstmt.setInt(3,customer.getAddress().getPincode());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBUtility.getInstance().dbClose();

		
		
	}

}
