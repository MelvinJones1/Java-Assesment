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
import com.springboot.rest_api.model.Manager;
import com.springboot.rest_api.model.Warehouse;
import com.springboot.rest_api.service.ManagerService;
import com.springboot.rest_api.service.WarehouseService;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {
	
	@Autowired
	private WarehouseService warehouseService;
	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/add/{managerId}")
	public Warehouse addWarehouse(@PathVariable int managerId,@RequestBody Warehouse warehouse) throws InvalidIdException {
		
		Manager manager = managerService.getById(managerId);
		
		warehouse.setManager(manager);
		
		warehouse = warehouseService.addWarehouse(warehouse);

		
		
		return warehouse;
				
	}
	
	@GetMapping("/all")
	public List<Warehouse> getAll(){
		
		return warehouseService.getAll();
	}
	


}
