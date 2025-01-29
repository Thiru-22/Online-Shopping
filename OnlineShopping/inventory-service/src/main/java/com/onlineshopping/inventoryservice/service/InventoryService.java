package com.onlineshopping.inventoryservice.service;

import com.onlineshopping.inventoryservice.entity.Inventory;

public interface InventoryService {
	 Inventory getInventoryByProductCode(String productCode);
	 Inventory updateInventory(String productCode, int quantity);
}
