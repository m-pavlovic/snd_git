package com.marijapavlovic.zadatak_2_3;

public class SndEncodingDecorator extends TextAreaDecorator {

    public SndEncodingDecorator(TextAreaInterface textAreaInterface) {
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
        String text = String.valueOf(textAreaInterface.getTextArea());
        String encodedText = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'a') {
                encodedText += 'z';
            } else if (c == 'A') {
                encodedText += 'Z';
            } else {
                encodedText += (char) (c - 1);
            }
        }
        textAreaInterface.setTextArea(encodedText);
    }
    
}
