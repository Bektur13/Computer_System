package com.bektur;

public class IdleState implements CacheState {
    @Override
    public void onPut(String key, int value) {
        System.out.println("[State: Idle] Putting key: " + key);
    }
    @Override
    public void onGet(String key) {
        System.out.println("[State: Idle] Getting key: " + key);
    }

}
