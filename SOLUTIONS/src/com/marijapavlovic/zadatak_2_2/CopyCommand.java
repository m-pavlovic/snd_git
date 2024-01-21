package com.marijapavlovic.zadatak_2_2;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
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
        try {
            previousClipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);
            String selectedText = viewPanel.getTextArea().getSelectedText();
            if (selectedText != null) {
                StringSelection stringSelection = new StringSelection(selectedText);
                clipboard.setContents(stringSelection, null);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void unexecute() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(previousClipboardText);
        clipboard.setContents(stringSelection, null);
    }
}