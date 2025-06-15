package com.bektur;

import java.util.Map;
import java.util.HashMap;

public class LFUCache implements Cache{
    private final int capacity;
    private final Map<String,Integer> cache;
    private final Map<String, Integer> usageCount;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<String, Integer>();
        this.usageCount = new HashMap<String, Integer>();
    }
    public void put(String key, int value) {
        if(capacity == 0) return;

        if(cache.containsKey(key)) {
            cache.put(key, value);
            usageCount.put(key, usageCount.get(key) + 1);
            return;
        }

        if(cache.size() >= capacity) {
            String leastUseKey = findLeastUsedKey();
            cache.remove(leastUseKey);
            usageCount.remove(leastUseKey);
        }

        cache.put(key, value);
        usageCount.put(key, 1);
    }

    public int get(String key) {
        if(!cache.containsKey(key)) return -1;

        usageCount.put(key, usageCount.get(key) + 1);
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
        usageCount.remove(key);
    }

    public void clear() {
        cache.clear();
        usageCount.clear();
    }

    public int size() {
        return cache.size();
    }

    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    public String findLeastUsedKey() {
        String minKey = null;
        int minCount = Integer.MAX_VALUE;

        for(Map.Entry<String, Integer> entry : usageCount.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();

            if(cache.containsKey(key) && count < minCount) {
                minCount = count;
                minKey = key;
            }
        }
        return minKey;
    }
}
