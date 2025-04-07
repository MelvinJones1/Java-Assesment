package com.springboot.rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest_api.exception.InvalidIdException;
import com.springboot.rest_api.model.Manager;
import com.springboot.rest_api.repository.ManagerRepository;

@Service
public class ManagerService {

	
	@Autowired
	private ManagerRepository managerRepository;
	
	
	
	public Manager addManager(Manager manager) {
		// TODO Auto-generated method stub
		
		return managerRepository.save(manager);
	}



	public Manager getById(int managerId) throws InvalidIdException{
		// TODO Auto-generated method stub
		Optional<Manager>  optional =  managerRepository.findById(managerId);
		if(optional.isEmpty()) {
			throw new InvalidIdException("Manager Id is not valid....");
		}
		return optional.get();
	}



	public List<Manager> getAll() {
		// TODO Auto-generated method stub
		return managerRepository.findAll();
	}

}
