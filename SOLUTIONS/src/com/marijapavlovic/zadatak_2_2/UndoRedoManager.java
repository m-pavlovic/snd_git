package com.marijapavlovic.zadatak_2_2;

import java.util.Stack;


public class UndoRedoManager {
    private Stack<CommandsInterface> undoStack = new Stack<>();
    private Stack<CommandsInterface> redoStack = new Stack<>();

    public void execute(CommandsInterface command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            CommandsInterface command = undoStack.pop();
            command.undoCommand();
            redoStack.push(command);
            System.out.println(undoStack);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            CommandsInterface command = redoStack.pop();
            command.execute();
            undoStack.push(command);
            System.out.println(redoStack);
        }
    }
}