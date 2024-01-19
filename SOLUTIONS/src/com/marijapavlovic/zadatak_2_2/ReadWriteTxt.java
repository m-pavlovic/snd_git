package com.marijapavlovic.zadatak_2_2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ReadWriteTxt implements ReadWriteStrategy {


    @Override
    public StringBuffer loadFromFile(String path) {
        StringBuffer sb = new StringBuffer();
        try {
            while (true) {
                sb.append(this.toString() + "\n");
            }
        } catch (Exception e){
            System.out.println("End of file reached.");
        }
        return sb;
    }

    @Override
    public void saveToFile(String path, Object textArea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), true))) {
            while (true) {
                bw.write(this.toString() + "\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
