package com.springboot.rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest_api.model.Review;
import com.springboot.rest_api.repository.ReviewRepository;


@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review addReviews(Review review) {
		// TODO Auto-generated method stub
		
		
		return reviewRepository.save(review);
	}

	public List<Review> getReviewByCustomerId(int cid) {
		// TODO Auto-generated method stub
		
		return reviewRepository.findByCustomerId(cid);
	}

	public List<Review> getReviewsByProductId(int pid) {
		// TODO Auto-generated method stub
		return reviewRepository.findByProductId(pid);
	}

}
