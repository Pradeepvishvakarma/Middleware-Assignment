package com.order.tracking.system.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.order.tracking.system.model.Order;
import com.order.tracking.system.model.dto.OrderDto;
import com.order.tracking.system.repository.OrderRepository;
import com.order.tracking.system.service.event.OrderEvent;

@Service
public class OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	private static final String DateTimeFormat = "dd-MMM-yyyy hh:mm:ss a";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";


	@Autowired
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;

	@Autowired
	private OrderRepository orderRepository;

	public void placeOrder(OrderDto orderDto) {
		Order order = new Order();
		order.setProduct(orderDto.getProduct());
		order.setQuantity(orderDto.getQuantity());
		order.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateTimeFormat)));
		orderRepository.save(order);
		OrderEvent event = new OrderEvent(order.getId(), order.getProduct(), order.getQuantity());
		logger.info("Sending the Order Request : {} to Inventory Management System ", event);
		kafkaTemplate.send("order-placed", event);
		logger.info( GREEN +"Order Request sent to Inventory Management System Successfully" + RESET );
	}

	public OrderDto convertToDto(Order order) {
		return new OrderDto(order.getProduct(), order.getQuantity());
	}
}
