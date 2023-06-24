package com.sachin.URLHITCOUNTER.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {
    private Map<String, Integer> hitCountMap = new HashMap<>();

    public void incrementHitCount() {
        // Increment the total hit count
        hitCountMap.merge("total", 1, Integer::sum);
    }

    public int getTotalHitCount() {
        return hitCountMap.getOrDefault("total", 0);
    }

    public int getUserHitCount(String username) {
        return hitCountMap.getOrDefault(username, 0);
    }

    public void incrementUserHitCount(String username) {
        hitCountMap.merge(username, 1, Integer::sum);
    }
}


