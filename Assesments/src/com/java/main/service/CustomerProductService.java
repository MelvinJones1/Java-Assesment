package com.java.main.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.java.main.model.Customer;
import com.java.main.repository.CustomerProductRepository;
import com.java.main.repository.ProductRepository;

public class CustomerProductService {
    private CustomerProductRepository customerProductRepository;
    private ProductRepository productRepository;

    public CustomerProductService() {
        this.customerProductRepository = new CustomerProductRepository();
        this.productRepository = new ProductRepository();
    }

    public boolean purchaseProduct(int customerId, int productId) {
        // Check if product is available
        int quantity = productRepository.getProductQuantity(productId);

        if (quantity > 0) {
            // Generate date of purchase
            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Insert into customer_product table
            boolean purchaseSuccess = customerProductRepository.addCustomerProduct(customerId, productId, formattedDate);

            if (purchaseSuccess) {
                // Reduce product quantity
                productRepository.updateProductQuantity(productId, quantity - 1);
                return true;
            }
        }
        return false;
    }
    
    public List<Customer> getCustomersByProductId(int productId) {
        return customerProductRepository.findCustomersByProductId(productId);
    }

}
