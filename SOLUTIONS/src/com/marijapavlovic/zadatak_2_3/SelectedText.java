package com.marijapavlovic.zadatak_2_3;

import javax.swing.*;

public class SelectedText implements TextAreaInterface {

    private JTextArea textArea;
    public SelectedText(JTextArea text) {
        this.textArea = text;
    }

    @Override
    public JTextArea getTextArea() {
        return textArea;
    }

    @Override
    public void setTextArea(String string) {
        textArea.setText(string);

    }
}
