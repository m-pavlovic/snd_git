package com.marijapavlovic.zadatak_2_2;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CutCommand implements CommandsInterface {

    private ViewPanel viewPanel;

    public CutCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }


    @Override
    public void execute() {
        String selectedText = viewPanel.getTextArea().getSelectedText();
        if (selectedText != null) {
            StringSelection stringSelection = new StringSelection(selectedText);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            viewPanel.getTextArea().replaceSelection("");
        }


    }

    @Override
    public void unexecute() {

    }
}
