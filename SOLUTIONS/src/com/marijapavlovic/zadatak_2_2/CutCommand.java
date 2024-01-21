package com.marijapavlovic.zadatak_2_2;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CutCommand implements CommandsInterface {

    
    private ViewPanel viewPanel;
    private String cutText;
    private int cutStart;
    private int cutEnd;

    public CutCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    @Override
    public void execute() {
        cutStart = viewPanel.getTextArea().getSelectionStart();
        cutEnd = viewPanel.getTextArea().getSelectionEnd();
        cutText = viewPanel.getTextArea().getSelectedText();
        if (cutText != null) {
            StringSelection stringSelection = new StringSelection(cutText);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            viewPanel.getTextArea().replaceSelection("");
        }
    }

    @Override
    public void unexecute() {
        viewPanel.getTextArea().insert(cutText, cutStart);
        viewPanel.getTextArea().setSelectionStart(cutStart);
        viewPanel.getTextArea().setSelectionEnd(cutEnd);
    }
}
