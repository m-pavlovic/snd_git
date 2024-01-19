package com.marijapavlovic.zadatak_2_2;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class PasteCommand implements CommandsInterface {

    private ViewPanel viewPanel;
    String selectedText;

    public PasteCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }


    @Override
    public void execute() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(selectedText);
        clipboard.setContents(stringSelection, null);
        if (selectedText != null) {
            viewPanel.getTextArea().replaceSelection(selectedText);
        }

    }

    @Override
    public void unexecute() {
        if (selectedText != null) {
            viewPanel.getTextArea().replaceSelection("");
        }
    }
}
