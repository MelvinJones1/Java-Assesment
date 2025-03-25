package com.java.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.main.model.Customer;
import com.java.main.utility.DBUtility;

public class CustomerProductRepository {

	public boolean addCustomerProduct(int customerId, int productId, String dateOfPurchase) {
        String query = "INSERT INTO customer_product (customer_id, product_id, date_of_purchase) VALUES (?, ?, ?)";
        
        try (Connection con = DBUtility.getInstance().dbConnect();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            pstmt.setInt(1, customerId);
            pstmt.setInt(2, productId);
            pstmt.setString(3, dateOfPurchase);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding customer product: " + e.getMessage(), e);
        } 
    }

    public List<Customer> findCustomersByProductId(int productId) {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT c.id, c.name, c.contact FROM customer c " +
                       "JOIN customer_product cp ON c.id = cp.customer_id " +
                       "WHERE cp.product_id = ?";
        
        try (Connection con = DBUtility.getInstance().dbConnect();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding customers for product ID " + productId + ": " + e.getMessage(), e);
        } 

        return customers;
    }

}
