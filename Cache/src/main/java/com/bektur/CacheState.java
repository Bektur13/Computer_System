package com.bektur;

public interface CacheState {
    void onPut(String key, int value);
    void onGet(String key);
}
