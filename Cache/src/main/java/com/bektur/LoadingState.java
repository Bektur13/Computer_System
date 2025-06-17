package com.bektur;

public class LoadingState implements CacheState {
    @Override
    public void onPut(String key, int value) {
        System.out.println("[State: Loading] Can't put now - still loading.");
    }

    @Override
    public void onGet(String key) {
        System.out.println("[State: Loading] Please wait - data is being loaded.");
    }
}
