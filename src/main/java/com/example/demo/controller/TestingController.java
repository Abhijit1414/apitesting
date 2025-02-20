package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bfhl")
public class TestingController {
   
    @PostMapping
    public Map<String, Object> processData(@RequestBody Map<String, List<String>> request) {
        Map<String, Object> response = new HashMap<>();
        
        if (!request.containsKey("data")) {
            response.put("is_success", false);
            response.put("message", "Invalid request format");
            return response;
        }
        
        List<String> data = request.get("data");
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        
        for (String item : data) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            } else {
                alphabets.add(item);
            }
        }
        
        response.put("is_success", true);
        response.put("user_id", "john_doe_17091999");
        response.put("email", "john@xyz.com");
        response.put("roll_number", "ABCD123");
        response.put("numbers", numbers);
        response.put("alphabets", alphabets);
        
        return response;
    }
}
