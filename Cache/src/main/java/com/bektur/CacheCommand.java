package com.bektur;

public interface CacheCommand {
    void execute();
    void undo();
}
