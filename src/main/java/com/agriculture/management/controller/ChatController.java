package com.agriculture.management.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Value("${anthropic.api.key}")
    private String apiKey;

    @PostMapping
    public ResponseEntity<String> chat(@RequestBody Map<String, Object> body) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apiKey);
        headers.set("anthropic-version", "2023-06-01");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
            "https://api.anthropic.com/v1/messages",
            request,
            String.class
        );

        return ResponseEntity.ok(response.getBody());
    }
}