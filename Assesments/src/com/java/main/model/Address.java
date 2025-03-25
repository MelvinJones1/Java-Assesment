package com.java.main.model;

public class Address {
	
	private int id;
	private String city;
	private int pincode;
	
	public Address(int id, String city, int pincode) {
		super();
		this.id = id;
		this.city = city;
		this.pincode = pincode;
	}

	public Address(String city, int pincode) {
		super();
		this.city = city;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
	
}
