package com.bektur;

public class RemoveCommand implements CacheCommand {
    private final Cache cache;
    private final String key;
    private Integer oldValue;

    public RemoveCommand(Cache cache, String key) {
        this.cache = cache;
        this.key = key;
    }

    @Override
    public void execute() {
        if(cache.containsKey(key)) {
            oldValue = cache.get(key);
            cache.remove(key);
        }
    }

    @Override
    public void undo() {
        if(oldValue != null) {
            cache.put(key, oldValue);
        }
    }
}
