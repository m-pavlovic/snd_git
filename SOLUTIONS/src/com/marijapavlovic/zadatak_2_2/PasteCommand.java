package com.marijapavlovic.zadatak_2_2;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public class PasteCommand implements CommandsInterface {
    private ViewPanel viewPanel;
    private String pastedText;
    private String previousClipboardText;
    private int pastePosition;

    public PasteCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    @Override
    public void execute() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            previousClipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);
            pastedText = previousClipboardText;
            pastePosition = viewPanel.getTextArea().getCaretPosition();
            viewPanel.getTextArea().insert(pastedText, pastePosition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unexecute() {
        viewPanel.getTextArea().select(pastePosition, pastePosition + pastedText.length());
        viewPanel.getTextArea().replaceSelection("");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(previousClipboardText);
        clipboard.setContents(stringSelection, null);
    }
}