package com.inventory.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.management.system.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	Inventory findByProduct(String product);
}
