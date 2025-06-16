package com.bektur;

public interface CacheEvictionStrategy {
    void onPut(String key);
    String evictKey();
}
