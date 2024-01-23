package com.marijapavlovic.zadatak_2_3;

import javax.swing.JTextArea;

public class SelectedText implements TextAreaInterface {

    private JTextArea textArea;

    public SelectedText(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public String getTextArea() {
        return textArea.getSelectedText();
    }

    @Override
    public void setTextArea(String string) {
        textArea.replaceSelection(string);
    }
    
}
