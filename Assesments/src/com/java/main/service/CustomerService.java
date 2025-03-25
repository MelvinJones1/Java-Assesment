package com.java.main.service;

import com.java.main.model.Customer;
import com.java.main.repository.CustomerRepository;

public class CustomerService {
	
	CustomerRepository customerRepository = new CustomerRepository();
	

	public void addCustomerWithAddress(Customer customer) {
		// TODO Auto-generated method stub
		
		customerRepository.addCustomerWithAddress(customer);
		
	}
	
	

}
