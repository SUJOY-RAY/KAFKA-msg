package com.kafkamsg.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkamsg.services.MessageProducer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageProducer producer;

    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }
    
    @PostMapping
    public ResponseEntity<String> send(@RequestBody String message) {
        producer.send(message);
        return ResponseEntity.ok("Message Sent to Kafka.");
    }
    
}
