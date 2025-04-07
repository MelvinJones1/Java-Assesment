package com.springboot.rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest_api.exception.InvalidIdException;
import com.springboot.rest_api.model.Customer;
import com.springboot.rest_api.model.CustomerProduct;
import com.springboot.rest_api.model.Product;
import com.springboot.rest_api.repository.CustomerProductRepository;

@Service
public class CustomerProductService {
	
	@Autowired
	private CustomerProductRepository customerProductRepository;
	
	@Autowired
	private CustomerService customerService;
//	
	@Autowired
	private ProductService productService;
	

	public CustomerProduct purchaseProduct(CustomerProduct customerProduct) {
		// TODO Auto-generated method stub
		
		
		return customerProductRepository.save(customerProduct);
	}


	public List<Customer> getCustomersByProduct(int pid) throws InvalidIdException {
		// TODO Auto-generated method stub
		
		 productService.getById(pid);
		
		
		
		List<CustomerProduct> customerProducts= customerProductRepository.findByProductId(pid);
//		List<Customer> list = new ArrayList<>();
//		
//		for(CustomerProduct cp : customerProducts) {
//			list.add(cp.getCustomer());
//		}
		
		return customerProducts.stream().map(cp->cp.getCustomer()).toList();
		
	}


	public List<Product> getProductsByCustomer(int cid) throws InvalidIdException {
		// TODO Auto-generated method stub
		
		 customerService.getSingleCustomer(cid);
		
		List<CustomerProduct> customerProducts= customerProductRepository.findByCustomerId(cid);
//		List<Product> list = new ArrayList<>();
//		
//		for(CustomerProduct cp : customerProducts) {
//			list.add(cp.getProduct());
//		}
		
		return customerProducts.stream().map(cp->cp.getProduct()).toList();
	}
	
	

}
