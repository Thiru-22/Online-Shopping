package com.onlineshopping.productservice.repository;

import com.onlineshopping.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryIdAndInventoryGreaterThan(Long categoryId, Integer inventory);
    Optional<Product> findByIdAndInventoryGreaterThan(Long id, Integer inventory);
}
