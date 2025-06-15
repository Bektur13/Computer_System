package com.bektur;

public class CacheDecorator implements Cache {
    private final Cache decoratedCache;

    public CacheDecorator(Cache cache) {
        this.decoratedCache = cache;
    }

    @Override
    public void put(String key, int value) {
        System.out.println("[LOG] Putting key: " + key + ", value: " + value);
        decoratedCache.put(key, value);
    }

    @Override
    public int get(String key) {
        System.out.println("[LOG] Getting key: " + key);
        return decoratedCache.get(key);
    }

    @Override
    public void remove(String key) {
        decoratedCache.remove(key);
    }

    @Override
    public void clear() {
        decoratedCache.clear();
    }

    @Override
    public int size() {
        return decoratedCache.size();
    }

    @Override
    public boolean containsKey(String key) {
        return decoratedCache.containsKey(key);
    }
}
