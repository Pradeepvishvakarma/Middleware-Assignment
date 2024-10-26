package com.order.tracking.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.order.tracking.system.model.dto.OrderDto;
import com.order.tracking.system.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto) {
    	logger.info("Order Placed for: {} ",orderDto);
        orderService.placeOrder(orderDto);
        return ResponseEntity.ok("Order placed successfully");
    }

	@PostMapping("/helloWorld/{userName}")
	public String helloWorld(@PathVariable String userName) {
    	logger.info("Welcome User : {} ",userName);
		return String.format("Hello %s , How may I help you ?", userName);
	}
}

