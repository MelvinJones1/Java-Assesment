package com.springboot.rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.rest_api.exception.InvalidContactException;
import com.springboot.rest_api.exception.InvalidIdException;
import com.springboot.rest_api.model.Customer;
import com.springboot.rest_api.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllEmployees(Pageable pageable) {
		// TODO Auto-generated method stub
		
		return customerRepository.findAll(pageable).getContent().parallelStream().filter(c->c.isActive()==true).toList();
	}
	
	public Customer getSingleCustomer(int id) throws InvalidIdException{
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isEmpty()) {
			throw new InvalidIdException("Customer Id is not valid....");
		}
		return optional.get();
	}

	public void hardDeleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.delete(customer);
		
	}

	public void softDeleteCustomer(Customer customer) {
 		customer.setActive(false);
 		customerRepository.save(customer); 
 		
 	}

	public List<Customer> getAllCustomersByContact(String contact) throws InvalidContactException{
		// TODO Auto-generated method stub
		if(contact.length() != 10)
 			throw new InvalidContactException("contact number invalid must be 10 digits..");
		return customerRepository.findByContact(contact);
	}

	public List<Customer> getByIsActive(boolean status) {
		// TODO Auto-generated method stub
		return customerRepository.findByIsActive(status);
	}


	

}
