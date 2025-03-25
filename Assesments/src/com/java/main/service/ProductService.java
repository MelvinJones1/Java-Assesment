package com.java.main.service;

import com.java.main.model.Product;
import com.java.main.repository.ProductRepository;

public class ProductService {

	ProductRepository productRepository = new ProductRepository();
	
	public void addProductWithCategory(Product product) {
		// TODO Auto-generated method stub
		productRepository.addProductWithCategory(product);
	}

	public void showAllProducts() {
		// TODO Auto-generated method stub
		productRepository.showAllProducts();
		
		
	}


	
	
	

}
