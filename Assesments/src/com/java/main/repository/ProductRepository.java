package com.java.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.main.model.Product;
import com.java.main.utility.DBUtility;

public class ProductRepository {

	public void addProductWithCategory(Product product) {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getInstance().dbConnect();
		
		String query = "insert into product values(?,?,?,?,?)";
		String query2 = "insert into category values(?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
						
			pstmt.setInt(1,product.getId());
			pstmt.setString(2,product.getTitle());
			pstmt.setDouble(3,product.getPrice());
			pstmt.setInt(4,product.getQuantity());
			pstmt.setInt(5,product.getCategory().getId());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(query2);
			pstmt.setInt(1,product.getCategory().getId());
			pstmt.setString(2,product.getCategory().getName());
			pstmt.setString(3,product.getCategory().getPriority());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBUtility.getInstance().dbClose();

		
	}
	 public void showAllProducts() {
	        Connection con = DBUtility.getInstance().dbConnect();
	        String query = "SELECT id, title, price, quantity FROM product";

	        try {
	            PreparedStatement pstmt = con.prepareStatement(query);
	            ResultSet rs = pstmt.executeQuery();

	            System.out.println("Available Products:");
	            System.out.println("ID   | Title  | Price  | Quantity");

	            while (rs.next()) {
	                System.out.println(rs.getInt("id") + " | " + 
	                                   rs.getString("title") + " | " + 
	                                   rs.getDouble("price") + " | " + 
	                                   rs.getInt("quantity"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtility.getInstance().dbClose();
	        }
	    }
	 
	 public int getProductQuantity(int productId) {
	        Connection con = DBUtility.getInstance().dbConnect();
	        String query = "SELECT quantity FROM product WHERE id = ?";

	        try {
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, productId);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                return rs.getInt("quantity");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtility.getInstance().dbClose();
	        }
	        return 0;
	    }

	
	
	 public void updateProductQuantity(int productId, int newQuantity) {
	        Connection con = DBUtility.getInstance().dbConnect();
	        String query = "UPDATE product SET quantity = ? WHERE id = ?";

	        try {
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, newQuantity);
	            pstmt.setInt(2, productId);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtility.getInstance().dbClose();
	        }
	    }
	
	
	

}
