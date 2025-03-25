package com.java.main.model;

public class CustomerProject {
	private int id;
	private Customer customer;
	private Product product;
	private String date;
	
	
	public CustomerProject() {
		super();
	}


	public CustomerProject(int id, Customer customer, Product product, String date) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
	

}
