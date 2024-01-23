package com.marijapavlovic.zadatak_2_3;

public abstract class TextAreaDecorator implements TextAreaInterface {

    protected TextAreaInterface textAreaInterface;

    public TextAreaDecorator(TextAreaInterface textAreaInterface) {
        this.textAreaInterface = textAreaInterface;
    }

    public abstract void encodeTextArea();
    
}
