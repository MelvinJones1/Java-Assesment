package com.springboot.rest_api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.rest_api.exception.InvalidIdException;
import com.springboot.rest_api.model.Category;
import com.springboot.rest_api.model.Product;
import com.springboot.rest_api.model.Vendor;
import com.springboot.rest_api.repository.CategoryRepository;
import com.springboot.rest_api.repository.ProductRepository;
import com.springboot.rest_api.repository.VendorRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	
	public Product add(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}


	public List<Product> getProductByCategory(int catId,Pageable pageable) throws InvalidIdException {
		// TODO Auto-generated method stub
		Optional<Category> optional = categoryRepository.findById(catId);
		
		if(optional.isEmpty()) {
			throw new InvalidIdException("Category Id is not valid.....");
		}
		
		return productRepository.findByCategoryId(catId, pageable);
	}


	public List<Product> getProductByVendor(int vid, Pageable pageable) throws InvalidIdException{
		// TODO Auto-generated method stub
			Optional<Vendor> optional = vendorRepository.findById(vid);
		
		if(optional.isEmpty()) {
			throw new InvalidIdException("Category Id is not valid.....");
		}
		
		return productRepository.findByVendorId(vid, pageable);
	}


	public Product getById(int pid) throws InvalidIdException{
		// TODO Auto-generated method stub
		Optional<Product> optional = productRepository.findById(pid);
		if(optional.isEmpty()) {
			throw new InvalidIdException("Product Id is not valid....");
		}
		return optional.get();
	}
	
	public Product uploadImage(MultipartFile file,int pid) throws IOException, InvalidIdException {
 		/*check if pid isvalid */
 		Product product = productRepository.findById(pid)
 				.orElseThrow(()->new InvalidIdException("Invalid PID given.."));
 		
 		List<String> allowedExtensions = Arrays.asList("png","jpg","jpeg","gif","svg"); 
 		String originalFileName = file.getOriginalFilename(); 
 		System.out.println(originalFileName);
 		String extension= originalFileName.split("\\.")[1];
 		/*Check weather extension is allowed or not */
 		if( !(allowedExtensions.contains(extension))) {
 			throw new RuntimeException("Image Type Invalid");
 		}
 		
 		
 		String uploadPath= "C:\\Users\\91739\\Downloads\\rest-api\\rest-api\\uploads";
 		
 		/*Create directory *///Check if directory is present else create it
 		Files.createDirectories(Paths.get(uploadPath));
 		/*Define full path with folder and image name */
 		Path path = Paths.get(uploadPath + "\\" +originalFileName); 
 		/*Copy the image into uploads path */
 		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
 		/*Save this path in Db */
 		product.setImageUrl(path.toString());
 		return productRepository.save(product);
 	}

}
