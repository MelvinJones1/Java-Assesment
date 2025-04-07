package com.springboot.rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest_api.exception.InvalidIdException;
import com.springboot.rest_api.model.Warehouse;
import com.springboot.rest_api.repository.WarehouseRepository;

@Service
public class WarehouseService {
	
	@Autowired
	private WarehouseRepository warehouseRepository;

	public Warehouse addWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehouseRepository.save(warehouse);
	}

	public Warehouse getById(int wid) throws InvalidIdException {
		// TODO Auto-generated method stub
		Optional<Warehouse>  optional =  warehouseRepository.findById(wid);
		if(optional.isEmpty()) {
			throw new InvalidIdException("Warehouse Id is not valid....");
		}
		return optional.get();
	}

	public List<Warehouse> getAll() {
		// TODO Auto-generated method stub
		return warehouseRepository.findAll();
	}

}
