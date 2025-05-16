package com.bektur;

public class CacheFactory {
    public static Cache createCache(String type, int capacity) {
        if(type.equalsIgnoreCase("LRU")) {
            return new LRUCache(capacity);
        }
        if(type.equalsIgnoreCase("FIFO")) {
            return new FIFOCache(capacity);
        }
        if(type.equalsIgnoreCase("LFU")) {
            return new LFUCache(capacity);
        }
        throw new IllegalArgumentException("Unsupported cache type: " + type);
    }
}
