package com.marijapavlovic.zadatak_2_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ReadWriteTxt implements ReadWriteStrategy {


    @Override
    public StringBuffer loadFromFile(String path) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(new File(path)));
            String line;
            while ((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    public void saveToFile(String path, String textArea) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
            bw.write(textArea);
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
