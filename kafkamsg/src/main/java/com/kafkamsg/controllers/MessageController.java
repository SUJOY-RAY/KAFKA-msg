package com.kafkamsg.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkamsg.services.MessageConsumer;
import com.kafkamsg.services.MessageProducer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageProducer producer;
    private final MessageConsumer consumer;

    public MessageController(MessageProducer producer, MessageConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @PostMapping
    public ResponseEntity<String> send(@RequestBody String message) {
        producer.send(message);
        return ResponseEntity.ok("Message Sent to Kafka.");
    }

    @GetMapping("/consumed")
    public List<String> consumed() {
        return consumer.getMessages();
    }
    
    
}
