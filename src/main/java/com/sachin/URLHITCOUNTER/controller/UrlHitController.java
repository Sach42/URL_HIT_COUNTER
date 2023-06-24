package com.sachin.URLHITCOUNTER.controller;

import com.sachin.URLHITCOUNTER.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    public UrlHitService urlHitService;

    @GetMapping("count")
    public ResponseEntity<Map<String, Object>> getHitCount() {
        int totalHitCount = urlHitService.getTotalHitCount();

        Map<String, Object> response = new HashMap<>();
        response.put("visitors", totalHitCount);

        return ResponseEntity.ok(response);
    }

    @GetMapping("username/{username}/count")
    public ResponseEntity<Map<String, Object>> getHitCountByUsername(@PathVariable("username") String username) {
        int userHitCount = urlHitService.getUserHitCount(username);

        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("hitcount", userHitCount);

        return ResponseEntity.ok(response);
    }
}


