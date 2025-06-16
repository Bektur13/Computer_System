package com.bektur;
import java.util.LinkedHashSet;

public class LRUEvictionStrategy implements CacheEvictionStrategy{
    private final LinkedHashSet<String> accessOrder = new LinkedHashSet<>();

    @Override
    public void onPut(String key) {
        accessOrder.remove(key);
        accessOrder.add(key);
    }

    @Override
    public String evictKey() {
        return accessOrder.iterator().next();
    }
}
