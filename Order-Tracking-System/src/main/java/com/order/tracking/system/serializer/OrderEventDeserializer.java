package com.order.tracking.system.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.tracking.system.service.event.OrderEvent;

import org.apache.kafka.common.serialization.Deserializer;

public class OrderEventDeserializer implements Deserializer<OrderEvent> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public OrderEvent deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, OrderEvent.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing OrderEvent", e);
        }
    }
}
