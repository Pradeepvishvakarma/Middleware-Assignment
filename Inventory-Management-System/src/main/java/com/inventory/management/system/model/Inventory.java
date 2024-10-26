package com.inventory.management.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String product;
	private int quantity;
	private String stockUpdateTime;
	private String previousOrderTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getStockUpdateTime() {
		return stockUpdateTime;
	}

	public void setStockUpdateTime(String stockUpdateTime) {
		this.stockUpdateTime = stockUpdateTime;
	}

	public String getPreviousOrderTime() {
		return previousOrderTime;
	}

	public void setPreviousOrderTime(String previousOrderTime) {
		this.previousOrderTime = previousOrderTime;
	}

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Inventory(Long id, String product, int quantity, String stockUpdateTime, String previousOrderTime) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.stockUpdateTime = stockUpdateTime;
		this.previousOrderTime = previousOrderTime;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", product=" + product + ", quantity=" + quantity + ", stockUpdateTime="
				+ stockUpdateTime + ", previousOrderTime=" + previousOrderTime + "]";
	}
}
