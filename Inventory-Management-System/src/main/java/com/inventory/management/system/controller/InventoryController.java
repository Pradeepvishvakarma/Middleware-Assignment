package com.inventory.management.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.system.dto.InventoryDto;
import com.inventory.management.system.model.Inventory;
import com.inventory.management.system.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/getAllInventory")
	public List<Inventory> getAllInventory() {
		logger.info("Fetching All Inventory's details");
		return inventoryService.findAll();
	}

	@GetMapping("/getAllInventoryByProduct/{product}")
	public Inventory getInventoryByProduct(@PathVariable String product) {
		logger.info("Fetching Inventory details for product : {} ",product);
		return inventoryService.findByProduct(product);
	}

	@PostMapping("/updateInventory")
	public Inventory updateInventory(@RequestBody InventoryDto inventorydDto) {
		logger.info("Updating Inventory details : {} ",inventorydDto);
		return inventoryService.updateInventory(inventorydDto);
	}
	
	@PostMapping("/addProductInInventory")
	public Inventory addInventory(@RequestBody InventoryDto inventoryDto) {
		logger.info("Adding New Product : {} in Inventory", inventoryDto);
		return inventoryService.addProductInInventory(inventoryDto);
	}
}
