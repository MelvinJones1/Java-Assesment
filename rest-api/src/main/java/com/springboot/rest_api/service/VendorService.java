package com.springboot.rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest_api.exception.InvalidIdException;
import com.springboot.rest_api.model.Vendor;
import com.springboot.rest_api.repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired
	private VendorRepository vendorRepository;

	public Vendor addVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendorRepository.save(vendor);
	}

	public List<Vendor> getAll() {
		// TODO Auto-generated method stub
		return vendorRepository.findAll();
	}

	public Vendor getById(int vid) throws InvalidIdException {
		// TODO Auto-generated method stub
		Optional<Vendor> optional = vendorRepository.findById(vid);
		
		if(optional.isEmpty()) {
			throw new InvalidIdException("Vendor Id is not valid....");
		}
		return optional.get();
		
		
	}
	
	

}
