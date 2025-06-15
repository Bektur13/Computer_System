package com.bektur;

public class CacheProxy implements Cache {
    private final Cache realCache;
    private final int maxSize;

    public CacheProxy(Cache realCache, int maxSize) {
        this.realCache = realCache;
        this.maxSize = maxSize;
    }

    @Override
    public void put(String key, int value) {
        System.out.println("[Proxy] Cache full. Cannot put key: " + key + ", value: " + value);
    }

    @Override
    public int get(String key) {
        return realCache.get(key);
    }

    @Override
    public void remove(String key) {
        realCache.remove(key);
    }

    @Override
    public void clear() {
        realCache.clear();
    }

    @Override
    public int size() {
        return realCache.size();
    }

    @Override
    public boolean containsKey(String key) {
        return realCache.containsKey(key);
    }
}
