package com.java.main.controller;

import java.util.List;
import java.util.Scanner;

import com.java.main.model.Customer;
import com.java.main.service.CustomerProductService;

public class CustomerProductController {
	CustomerProductService customerProductService = new CustomerProductService();
    Scanner sc = new Scanner(System.in);

	
	public void purchaseProduct() {
        

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();

        boolean success = customerProductService.purchaseProduct(customerId, productId);

        if (success) {
            System.out.println(" Product purchased successfully!");
        } else {
            System.out.println(" Purchase failed. Product might be out of stock.");
        }
    }
	
	public void displayCustomersByProductId() {
        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();

        List<Customer> customers = customerProductService.getCustomersByProductId(productId);

        if (customers.isEmpty()) {
            System.out.println("No customers found for this product.");
        } else {
            System.out.println("Customers who purchased Product ID " + productId + ":");
            for (Customer customer : customers) {
                System.out.println("ID: " + customer.getId() + ", Name: " + customer.getName() + ", Contact: " + customer.getContact());
            }
        }
    }


}
	


