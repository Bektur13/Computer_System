package com.bektur;

public interface Cache {
    void put(String key, int value);
    int get(String key);
    void remove(String key);
    void clear();
    int size();
    boolean containsKey(String key);
}