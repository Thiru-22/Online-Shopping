package com.onlineshopping.inventoryservice.service;

import com.onlineshopping.inventoryservice.exception.InventoryNotFoundException;
import com.onlineshopping.inventoryservice.entity.Inventory;
import com.onlineshopping.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    // Manually add the constructor if @RequiredArgsConstructor doesn't work
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory getInventoryByProductCode(String productCode) {
        return inventoryRepository.findByProductCode(productCode)
                .orElseThrow(() -> new InventoryNotFoundException("Inventory not found for product: " + productCode));
    }

    @Override
    public Inventory updateInventory(String productCode, int quantity) {
        Inventory inventory = inventoryRepository.findByProductCode(productCode)
                .orElseThrow(() -> new InventoryNotFoundException("Inventory not found for product: " + productCode));
        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }
}
