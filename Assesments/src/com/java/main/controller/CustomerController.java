package com.java.main.controller;

import java.util.Scanner;

import com.java.main.model.Address;
import com.java.main.model.Customer;
import com.java.main.service.CustomerService;
import com.java.main.utility.RandomId;

public class CustomerController {
	
		CustomerService customerService = new CustomerService();
	

	Scanner sc = new Scanner(System.in);
	
	public void addCustomerWithAddress() {
		System.out.println("Enter the name of the customer");
		String name = sc.nextLine();
		System.out.println("Enter the contact of the customer");
		String contact = sc.nextLine();
		System.out.println("Enter the city of the customer");
		String city = sc.nextLine();
		System.out.println("Enter the pincode  of the customer");
		int pincode = sc.nextInt();
		
		Customer customer  = new Customer(name,contact);
		Address address = new Address(city,pincode);
		
		
		int pId = (int)RandomId.getInstanceId().getRandomId();
		int cId = (int) RandomId.getInstanceId().getRandomId();
		
		customer.setId(pId);
		address.setId(cId);
		
		customer.setAddress(address);
		
		customerService.addCustomerWithAddress(customer);
		
		
	}
	

}
