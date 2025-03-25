package com.java.main;

import java.util.Scanner;
import com.java.main.controller.CustomerController;
import com.java.main.controller.ProductController;
import com.java.main.controller.CustomerProductController;

public class App {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        CustomerController customerController = new CustomerController();
        CustomerProductController customerProductController = new CustomerProductController();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add product with category");
            System.out.println("2. Add customer with address");
            System.out.println("3. Purchase product");
            System.out.println("4. Display all customers purchased by Product ID");
            System.out.println("0. To exit");

            System.out.print("Choose your task: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    productController.addProductWithCategory();
                    System.out.println("Product added with category successfully");
                    break;
                case 2:
                    customerController.addCustomerWithAddress();
                    System.out.println("Customer added with address successfully");
                    break;
                case 3:
                	productController.showAllProducts();
                    customerProductController.purchaseProduct(); 
                    break;
                case 4:
                    customerProductController.displayCustomersByProductId();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
