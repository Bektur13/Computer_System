package com.bektur;

public class FullState implements CacheState{
    @Override
    public void onPut(String key, int vlaue) {
        System.out.println("[State: Full] Cache is full! Need to evict before putting " + key );
    }

    @Override
    public void onGet(String key) {
        System.out.println("[State: Full] Still serving data: " + key);
    }
}
