package com.onlineshopping.priceservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/product/{id}/price")
    public Double getPrice(@PathVariable("id") Long productId) {
        return priceService.getPriceForProduct(productId);
    }
}
