package com.bektur;

import java.util.Stack;

public class CommandCacheManager {
    private final Stack<CacheCommand> undoStack = new Stack<>();
    private final Stack<CacheCommand> redoStack = new Stack<>();

    public void executeCommand(CacheCommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if(!undoStack.isEmpty()) {
            CacheCommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }
}
