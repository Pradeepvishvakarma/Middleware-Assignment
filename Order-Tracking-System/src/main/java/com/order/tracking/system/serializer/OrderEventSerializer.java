package com.order.tracking.system.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.tracking.system.service.event.OrderEvent;

import org.apache.kafka.common.serialization.Serializer;

public class OrderEventSerializer implements Serializer<OrderEvent> {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public byte[] serialize(String topic, OrderEvent data) {
		try {
			return objectMapper.writeValueAsBytes(data);
		} catch (Exception e) {
			throw new RuntimeException("Error serializing OrderEvent", e);
		}
	}
}
