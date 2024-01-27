package com.marijapavlovic.zadatak_2_3;


import javax.swing.*;

public class FstEncodingDecorator extends TextAreaDecorator {

    public FstEncodingDecorator(TextAreaInterface textAreaInterface) {
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
        String textArea = String.valueOf(textAreaInterface.getTextArea().getText());
        if (textArea == null) {
            JOptionPane.showMessageDialog(null, "No text to encode!");
            return;
        } else {
            StringBuilder encoded = new StringBuilder();

            for (char c : textArea.toCharArray()) {
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

            textAreaInterface.getTextArea().setText("");
            textAreaInterface.setTextArea(encoded.toString());
        }
    }




}
