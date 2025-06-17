package com.bektur;

import java.util.HashMap;
import java.util.Map;

public class StatefulCache implements Cache{
    private final int capacity;
    private final Map<String, Integer> store = new HashMap<>();
    private CacheState state;

    public StatefulCache(int capacity) {
        this.capacity = capacity;
        this.state = new IdleState();
    }

    public void setState(CacheState state) {
        this.state = state;
    }

    @Override
    public int get(String key) {
        state.onGet(key);
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
