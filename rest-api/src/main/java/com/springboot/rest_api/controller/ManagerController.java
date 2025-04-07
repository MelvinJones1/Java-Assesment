package com.springboot.rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest_api.model.Manager;
import com.springboot.rest_api.service.ManagerService;

@RestController
@RequestMapping("/api/Manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/add")
	public Manager addManger(@RequestBody Manager manager) {
		
		return managerService.addManager(manager);
		
	}
	
	@GetMapping("/all")
	public List<Manager> getAll(){
		return managerService.getAll();
	}
}
