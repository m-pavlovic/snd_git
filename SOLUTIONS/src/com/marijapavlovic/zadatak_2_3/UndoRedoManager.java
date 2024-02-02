package com.marijapavlovic.zadatak_2_3;

import javax.swing.*;
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
        } else {
            JOptionPane.showMessageDialog(null, "Nothing to undo");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            CommandsInterface command = redoStack.pop();
            command.execute();
            undoStack.push(command);
            System.out.println(redoStack);
        } else {
            JOptionPane.showMessageDialog(null, "Nothing to redo");
        }
    }
}