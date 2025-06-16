package com.bektur;

import java.util.HashMap;
import java.util.Map;

public class StrategyCache implements Cache {
    private final int capacity;
    private final Map<String, Integer> store = new HashMap<>();
    private final CacheEvictionStrategy strategy;

    public StrategyCache(int capacity, CacheEvictionStrategy strategy) {
        this.capacity = capacity;
        this.strategy = strategy;
    }

    @Override
    public void put(String key, int value) {
        if(store.size() >= capacity && !store.containsKey(key)) {
            String keyToEvict = strategy.evictKey();
            store.remove(keyToEvict);
            System.out.println("[Strategy] Evicted: " + keyToEvict);
        }
        store.put(key, value);
        strategy.onPut(key);
    }

    @Override
    public int get(String key) {
        return store.getOrDefault(key, -1);
    }

    @Override
    public void remove(String key) {
        store.remove(key);
    }

    @Override
    public void clear() {
        store.clear();
    }

    @Override
    public int size() {
        return store.size();
    }

    @Override
    public boolean containsKey(String key) {
        return store.containsKey(key);
    }
}
