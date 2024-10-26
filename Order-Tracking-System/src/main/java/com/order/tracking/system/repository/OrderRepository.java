package com.order.tracking.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.tracking.system.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
