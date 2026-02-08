package com.kafkamsg.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    @KafkaListener(topics = "messages", groupId = "message-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
