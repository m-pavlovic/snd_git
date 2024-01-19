package com.marijapavlovic.zadatak_2_2;


import java.io.*;

public class ReadWriteBin implements ReadWriteStrategy {

    @Override
    public StringBuffer loadFromFile(String path) {
        StringBuffer sb = new StringBuffer();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)))){
            while (true){
                Object element = ois.readObject();
                sb.append(element).append("\n");
            }
        } catch (Exception e){
            System.out.println("End of file reached.");
        }
        return sb;

    }

    @Override
    public void saveToFile(String path, String textArea) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)))){
            oos.writeObject(textArea);
        } catch (Exception e){
            System.out.println("Error while writing to file.");
        }

    }
}
