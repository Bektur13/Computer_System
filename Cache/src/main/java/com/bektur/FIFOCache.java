package com.bektur;

import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOCache implements Cache {
    private final int capacity;
    private final LinkedHashMap<String, Integer> cache;
    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<String, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > FIFOCache.this.capacity;
            }
        };
    }
    public void put(String key, int value) {
        cache.put(key, value);
    }
    public int get(String key) {
        Integer value = cache.get(key);
        if(value == null) {
            return -1;
        }
        return value;
    }
    public void remove(String key) {
        cache.remove(key);
    }
    public void clear() {
        cache.clear();
    }
    public int size() {
        return cache.size();
    }
    public boolean consistKey(String key) {
        return cache.containsKey(key);
    }
}
