package com.marijapavlovic.zadatak_2_3;

public class FstEncodingDecorator extends TextAreaDecorator {

    public FstEncodingDecorator(TextAreaInterface textAreaInterface) {
        super(textAreaInterface);
    }

    @Override
    public String getTextArea() {
        return textAreaInterface.getTextArea();
    }

    @Override
    public void setTextArea(String string) {
        textAreaInterface.setTextArea(string);
    }

    @Override
    public void encodeTextArea() {
        String textArea = String.valueOf(textAreaInterface.getTextArea());
        String encodedTextArea = "";
        for (int i = 0; i < textArea.length(); i++) {
            char c = textArea.charAt(i);
            if (c == 'z') {
                encodedTextArea += 'a';
            } else if (c == 'Z') {
                encodedTextArea += 'A';
            } else {
                encodedTextArea += (char) (c + 1);
            }
        }
        textAreaInterface.setTextArea(encodedTextArea);
    }
    
}
