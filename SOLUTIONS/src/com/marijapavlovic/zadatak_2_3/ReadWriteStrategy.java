package com.marijapavlovic.zadatak_2_3;


public interface ReadWriteStrategy {


    StringBuffer loadFromFile(String path);

    void saveToFile(String path, Object textArea);
}
