package com.springboot.rest_api.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import com.springboot.rest_api.dto.MessageResponseDto;
import com.springboot.rest_api.exception.InvalidIdException;
import com.springboot.rest_api.model.Category;
import com.springboot.rest_api.model.Product;
import com.springboot.rest_api.model.Vendor;
import com.springboot.rest_api.model.Warehouse;
import com.springboot.rest_api.service.CategoryService;
import com.springboot.rest_api.service.ProductService;
import com.springboot.rest_api.service.VendorService;
import com.springboot.rest_api.service.WarehouseService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
//	@Autowired
//	private MessageResponseDto dto;
	
	@Autowired
	private WarehouseService warehouseService;
		
	@PostMapping("add/{catId}/{vid}/{wid}")
	public Product addProduct(@PathVariable int catId, @PathVariable int vid,@PathVariable int wid, @RequestBody Product product) throws InvalidIdException{
		
		Category category = categoryService.getById(catId);
		
		Vendor  vendor = vendorService.getById(vid);
		
		Warehouse warehouse = warehouseService.getById(wid);
		
		
		product.setCategory(category);
		product.setVendor(vendor);
		product.setWarehouse(warehouse);
		
		product = productService.add(product);
		
		return product;		
		
	}
	
	@GetMapping("/category/{catId}")
	public List<Product> getProductByCategory(@PathVariable int catId, @RequestParam int page, @RequestParam int size) throws InvalidIdException{
			
		Pageable pageable = PageRequest.of(page, size);
		
		
			List<Product>list = productService.getProductByCategory(catId,pageable);
			return list;
		
		
	}
	
	
	@GetMapping("/vendor/{vid}")
	public List<Product> getProductByVendor(@PathVariable int vid, @RequestParam int page, @RequestParam int size) throws InvalidIdException{
			
		Pageable pageable = PageRequest.of(page, size);
		
		
			List<Product>list = productService.getProductByVendor(vid,pageable);
			return list;		
		
	}
	
	@PostMapping("/image/upload/{pid}")
 	public Product uploadImage(@PathVariable int pid, 
 							@RequestParam MultipartFile file) throws IOException, InvalidIdException {
 		
 		return productService.uploadImage(file,pid);
 	}
}
