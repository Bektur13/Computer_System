package com.bektur;

public class CacheDecorator implements Cache{
    private final Cache decoratedCache;

    public CacheDecorator(Cache cache) {
        this.decoratedCache = cache;
    }

    @Override
    public void get(String key, int value) {
        
    }
}
