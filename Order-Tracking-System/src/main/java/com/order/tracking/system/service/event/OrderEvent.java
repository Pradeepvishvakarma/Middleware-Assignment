package com.order.tracking.system.service.event;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.order.tracking.system.model.Order;

public class OrderEvent {
	private Long orderId;
	private String product;
	private int quantity;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	@JsonCreator
	public OrderEvent(@JsonProperty("orderId") Long orderId, @JsonProperty("product") String product,
			@JsonProperty("quantity") int quantity) {
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
	}

	public OrderEvent() {
		super();
	}

	public OrderEvent(Order order) {
	}

	@Override
	public String toString() {
		return "OrderEvent [orderId=" + orderId + ", product=" + product + ", quantity=" + quantity +"]";
	}

}
