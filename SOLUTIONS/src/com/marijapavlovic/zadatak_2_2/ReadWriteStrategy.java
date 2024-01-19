package com.marijapavlovic.zadatak_2_2;

public interface ReadWriteStrategy {


    StringBuffer loadFromFile(String path);

    void saveToFile(String path, String textArea);
}
