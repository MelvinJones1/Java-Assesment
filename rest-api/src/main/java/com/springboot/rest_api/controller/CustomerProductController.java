package com.springboot.rest_api.controller;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest_api.exception.InvalidIdException;
import com.springboot.rest_api.model.Customer;
import com.springboot.rest_api.model.CustomerProduct;
import com.springboot.rest_api.model.Product;
import com.springboot.rest_api.service.CustomerProductService;
import com.springboot.rest_api.service.CustomerService;
import com.springboot.rest_api.service.ProductService;

@RestController
@RequestMapping("/api/customer/product")
public class CustomerProductController {

	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerProductService customerProductService;


    CustomerProductController(ProductService productService) {
        this.productService = productService;
    }
	
	
	@PostMapping("/purchase/{cid}/{pid}")
	public CustomerProduct purchaseProduct(@PathVariable int cid, @PathVariable int pid, @RequestBody CustomerProduct customerProduct) throws InvalidIdException {
		
			Customer customer = customerService.getSingleCustomer(cid);
			
			Product product = productService.getById(pid);
			
			if(customerProduct.getDateOfPurchase() == null) {
				customerProduct.setDateOfPurchase(LocalDate.now());
			}
			
			
			customerProduct.setCustomer(customer);
			customerProduct.setProduct(product);
			
			customerProduct = customerProductService.purchaseProduct(customerProduct);
			
			return customerProduct;
		
	}
	
		@GetMapping("/v1/{pid}")
		public List<Customer> getCustomersByProduct(@PathVariable int pid) throws InvalidIdException {
			
				
				List<Customer> list = customerProductService.getCustomersByProduct(pid);
				return list;
					
		}
		
		@GetMapping("/v2/{cid}")
		public List<Product> getProductsByCustomer(@PathVariable int cid) throws InvalidIdException{
				
				
				List<Product> list = customerProductService.getProductsByCustomer(cid);
				return list;
					
		}
//		
}
