package com.onlineshopping.categoryservice;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    public Category getCategoryById(int categoryId) {
        // In a real scenario, fetch category data from DB
    	
        return new Category(categoryId, "Electronics");
    }
}
