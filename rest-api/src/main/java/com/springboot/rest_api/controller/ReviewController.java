package com.springboot.rest_api.controller;

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
import com.springboot.rest_api.model.Product;
import com.springboot.rest_api.model.Review;
import com.springboot.rest_api.service.CustomerService;
import com.springboot.rest_api.service.ProductService;
import com.springboot.rest_api.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private CustomerService customerService;	
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping("/add/{cid}/{pid}")
	public Review addReviews(@PathVariable int cid, @PathVariable int pid, @RequestBody Review review) throws InvalidIdException {
		
		Customer customer = customerService.getSingleCustomer(cid);
		
		Product product = productService.getById(pid);
		
		review.setCustomer(customer);
		review.setProduct(product);
		
		return reviewService.addReviews(review);
	

	}
	
	@GetMapping("/v1/{cid}")
	public List<Review> getReviewByCustomerId(@PathVariable int cid){
		
		return reviewService.getReviewByCustomerId(cid);
		
	}
	
	@GetMapping("/v2/{pid}")
	public List<Review> getReviewsByProductId(@PathVariable int pid){
		
		return reviewService.getReviewsByProductId(pid);
		
	}

}
