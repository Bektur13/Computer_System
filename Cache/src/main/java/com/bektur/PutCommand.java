package com.bektur;

public class PutCommand implements CacheCommand{
    private final Cache cache;
    private final String key;
    private final int value;
    private Integer previousKey;

    public PutCommand(Cache cache, String key, int value) {
        this.cache = cache;
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        if(cache.containsKey(key)) {
            previousKey = cache.get(key);
        }
        cache.put(key, value);
    }

    @Override
    public void undo() {
        if(previousKey != null) {
            cache.put(key, value);
        }else {
            cache.remove(key);
        }
    }
}
