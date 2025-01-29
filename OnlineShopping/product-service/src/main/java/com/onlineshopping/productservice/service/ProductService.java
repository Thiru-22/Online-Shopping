package com.onlineshopping.productservice.service;

import com.onlineshopping.productservice.entity.Product;
import com.onlineshopping.productservice.exception.ProductNotFoundException;
import com.onlineshopping.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Add a new product
    @Transactional
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product
    @Transactional
    public Product updateProduct(Long productId, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setBrand(updatedProduct.getBrand());
            product.setPrice(updatedProduct.getPrice());
            product.setInventory(updatedProduct.getInventory());
            return productRepository.save(product);
        }
        throw new ProductNotFoundException("Product with id " + productId + " not found");
    }

    // Remove a product by ID
    @Transactional
    public void removeProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    // View products by category with sufficient inventory
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryIdAndInventoryGreaterThan(categoryId, 0);
    }
}
