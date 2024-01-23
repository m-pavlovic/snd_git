package com.marijapavlovic.zadatak_2_3;

import javax.swing.*;

public class SndEncodingDecorator extends TextAreaDecorator {

    public SndEncodingDecorator(TextAreaInterface textAreaInterface) {
        super(textAreaInterface);
    }

    @Override
    public JTextArea getTextArea() {
        return textAreaInterface.getTextArea();
    }

    @Override
    public void setTextArea(String string) {
        textAreaInterface.setTextArea(string);
    }

    @Override
    public void encodeTextArea() {
        if (getTextArea() == null) {
            JOptionPane.showMessageDialog(null, "No text to encode!");
            return;
        } else {
            StringBuilder encoded = new StringBuilder(getTextArea().getText());
            for (char c : getTextArea().getText().toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    c++;
                } else if (c == 'z') {
                    c = 'a';
                } else if (c >= 'A' && c <= 'Z') {
                    c++;
                } else if (c == 'Z') {
                    c = 'A';
                }
                encoded.append(c);
            }
            setTextArea(encoded.toString());
        }
    }
    
}
