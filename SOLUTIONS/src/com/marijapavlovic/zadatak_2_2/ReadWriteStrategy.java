package com.marijapavlovic.zadatak_2_2;

import javax.swing.*;

public interface ReadWriteStrategy {


    StringBuffer loadFromFile(String path);

    void saveToFile(String path, Object textArea);
}
