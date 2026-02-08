package com.kafkamsg;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<String> helloMessage() {
        return ResponseEntity.ok("Hello from Kafka Message Application!");
    }

}
