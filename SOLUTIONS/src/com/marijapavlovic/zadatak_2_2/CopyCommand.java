package com.marijapavlovic.zadatak_2_2;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CopyCommand implements CommandsInterface {
    private ViewPanel viewPanel;
    private String previousClipboardText;

    public CopyCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    @Override
    public void execute() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String selectedText = viewPanel.getTextArea().getSelectedText();

        if (selectedText != null) {
            StringSelection stringSelection = new StringSelection(selectedText);
            clipboard.setContents(stringSelection, null);
        }
    }


    @Override
    public void undoCommand() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if (previousClipboardText != null) {
            StringSelection stringSelection = new StringSelection(previousClipboardText);
            clipboard.setContents(stringSelection, null);
        }
    }
}