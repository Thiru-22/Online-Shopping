package com.onlineshopping.adminservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.onlineshopping.adminservice.Product;

@Service
public class AdminService {
    
    private final RestTemplate restTemplate;

    public AdminService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Updates an existing product via ProductService.
     */
    public String updateProduct(Product product) {
        String productServiceUrl = "http://localhost:8081/api/products/" + product.getId();
        ResponseEntity<String> response = restTemplate.postForEntity(productServiceUrl, product, String.class);

        return response.getBody(); // Return response from ProductService
    }

    /**
     * Deletes a product via ProductService.
     */
    public String deleteProduct(Long productId) {
        String productServiceUrl = "http://localhost:8081/api/products/" + productId;
        restTemplate.delete(productServiceUrl);
        
        return "Product with ID " + productId + " deleted successfully from ProductService.";
    }
}
