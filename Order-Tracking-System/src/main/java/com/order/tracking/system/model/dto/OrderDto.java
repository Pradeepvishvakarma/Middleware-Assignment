package com.order.tracking.system.model.dto;

import org.springframework.stereotype.Component;

@Component
public class OrderDto {

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
	public OrderDto(String product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDto [product=" + product + ", quantity=" + quantity + "]";
	}
}
