package com.bektur;

public class CacheFacade {
    public static Cache createLRUCache(int capacity) {
        return CacheFactory.createCache("LRU", capacity);
    }
    public static Cache createLFUCache(int capacity) {
        return CacheFactory.createCache("LFU", capacity);
    }
    public static Cache createFIFOCache(int capacity) {
        return CacheFactory.createCache("FIFO", capacity);
    }
}
