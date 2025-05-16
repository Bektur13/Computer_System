package com.bektur;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache implements Cache{
    private final int capacity;
    private final LinkedHashMap<String, Integer> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > LRUCache.this.capacity;
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