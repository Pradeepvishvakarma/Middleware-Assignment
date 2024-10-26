package com.inventory.management.system.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.inventory.management.system.dto.InventoryDto;
import com.inventory.management.system.event.OrderEvent;
import com.inventory.management.system.model.Inventory;
import com.inventory.management.system.repository.InventoryRepository;

@Service
public class InventoryService {

	private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);
	private static final String DateTimeFormat = "dd-MMM-yyyy hh:mm:ss a";
	public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";

	@Autowired
	private InventoryRepository inventoryRepository;

	@KafkaListener(topics = "order-placed", groupId = "inventory-group")
	public void handleOrderPlaced(OrderEvent order) {
		logger.info(GREEN + "Received Order Request from Order Tracking Service : {} ", order + RESET);
		Inventory inventory = inventoryRepository.findByProduct(order.getProduct());
		if (inventory != null) {
			if (inventory.getQuantity() >= order.getQuantity()) {
				inventory.setQuantity(inventory.getQuantity() - order.getQuantity());
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateTimeFormat);

				String formattedDateTime = now.format(formatter);
				inventory.setPreviousOrderTime(formattedDateTime);
				inventoryRepository.save(inventory);
				logger.info("Order processed successfully. Inventory updated : {} ", inventory);

			} else {
				logger.warn(
						"\nInsufficient Stock   !!! \nCurrent stock for {} product is {} unit only, but requested stock is {} \nUnable to Proceed with your Order Request",
						inventory.getProduct(), inventory.getQuantity(), order.getQuantity());
			}
		} else {
			logger.error("Product {} not found in Inventory ", order.getProduct());
		}
	}

	public Inventory updateInventory(InventoryDto inventoryDto) {
		Inventory inventoryInStock = null;
		if (inventoryDto != null && inventoryDto.getProduct() != null) {
			inventoryInStock = inventoryRepository.findByProduct(inventoryDto.getProduct());
			if (inventoryInStock != null) {
				{
					inventoryInStock.setQuantity(inventoryDto.getQuantity() + inventoryInStock.getQuantity());
					inventoryInStock.setStockUpdateTime(
							LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateTimeFormat)));
					if (inventoryInStock.getPreviousOrderTime() == null) {
						inventoryInStock.setPreviousOrderTime("No Sale !!!");
					}
					logger.info("Inventory Updated successfully");
					inventoryRepository.save(inventoryInStock);
				}
			}
		}
		return inventoryInStock;
	}

	public Inventory findByProduct(String product) {
		logger.info("fetching Product {} from Inventory", product);
		return inventoryRepository.findByProduct(product);
	}

	public List<Inventory> findAll() {
		logger.info("fetching All Inventory successfully");
		return inventoryRepository.findAll();
	}

	public Inventory addProductInInventory(InventoryDto inventoryDto) {
		Inventory inventory = new Inventory();
		inventory.setProduct(inventoryDto.getProduct());
		inventory.setQuantity(inventoryDto.getQuantity());
		inventory.setStockUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateTimeFormat)));
		inventory.setPreviousOrderTime("No Sale !!");
		logger.info("New Product {} added in Inventory successfully ", inventory);
		return inventoryRepository.save(inventory);
	}

	public InventoryDto convertToDto(Inventory inventory) {
		return new InventoryDto(inventory.getProduct(), inventory.getQuantity());
	}

}
