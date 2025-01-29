package com.onlineshopping.inventoryservice.controller;

import com.onlineshopping.inventoryservice.entity.Inventory;
import com.onlineshopping.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{productCode}")
    public Inventory getInventory(@PathVariable String productCode) {
        return inventoryService.getInventoryByProductCode(productCode);
    }

    @PutMapping("/{productCode}")
    public Inventory updateInventory(@PathVariable String productCode, @RequestParam int quantity) {
        return inventoryService.updateInventory(productCode, quantity);
    }
}
