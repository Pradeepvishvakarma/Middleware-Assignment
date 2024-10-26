package com.inventory.management.system.dto;

import org.springframework.stereotype.Component;

@Component
public class InventoryDto {

	private String product;
	private int quantity;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "InventoryDto [product=" + product + ", quantity=" + quantity + "]";
	}
	public InventoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InventoryDto(String product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
}
