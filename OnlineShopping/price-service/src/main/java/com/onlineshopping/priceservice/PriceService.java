package com.onlineshopping.priceservice;

import org.springframework.stereotype.Service;

@Service
public class PriceService {

    public Double getPriceForProduct(Long productId) {
        // In a real scenario, this would fetch from a database
        return 99.99;  // Example price
    }
}
