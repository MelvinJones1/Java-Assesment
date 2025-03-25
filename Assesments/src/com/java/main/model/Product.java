package com.java.main.model;

public class Product {
	private int id;
	private String title;
	private double price;
	private int quantity;
	private Category category;
	
	
	
	public Product() {
		super();
	}



	public Product(String title, double price, int quantity, Category category) {
		super();
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	
	



	public Product(String title, double price, int quantity) {
		super();
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}





	public Product(int id, String title, double price, int quantity) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}



	



	
	
	
	
	

}
