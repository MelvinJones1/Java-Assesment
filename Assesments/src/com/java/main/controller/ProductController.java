package com.java.main.controller;

import java.util.Scanner;

import com.java.main.model.Category;
import com.java.main.model.Product;
import com.java.main.service.ProductService;
import com.java.main.utility.RandomId;

public class ProductController {
	ProductService productService = new ProductService();
	

	Scanner sc = new Scanner(System.in);
	
	public void addProductWithCategory() {
		System.out.println("Enter the title of the product");
		String title = sc.next();
		System.out.println("Enter the price of the product");
		double price = sc.nextDouble();
		System.out.println("Enter the quantity of the product");
		int quantity = sc.nextInt();
		System.out.println("Enter the name of the category");
		String name = sc.next();
		System.out.println("Enter the priority  of the category");
		String priority = sc.next();
		
		Product product  = new Product(title,price,quantity);
		Category category = new Category(name,priority);
		
		
		int pId = (int)RandomId.getInstanceId().getRandomId();
		int cId = (int) RandomId.getInstanceId().getRandomId();
		
		product.setId(pId);
		category.setId(cId);
		
		product.setCategory(category);
		
		productService.addProductWithCategory(product);
		
		
	}

	public void showAllProducts() {
		// TODO Auto-generated method stub
		productService.showAllProducts();
		
	}

	
}
