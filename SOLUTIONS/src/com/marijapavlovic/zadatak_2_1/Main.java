package com.marijapavlovic.zadatak_2_1;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String pathToFile = "DATA/csvData.csv";
        CSVUtils<Records> csvUtils = new CSVUtils<>();
        StartingDataContainer<Records> startingDataContainer = csvUtils.readFromFile(pathToFile, true, Records.class);
        csvUtils.listAllRecords(startingDataContainer.getData(), startingDataContainer.getHeaders());
        csvUtils.listParticularRecord(startingDataContainer.getData(), 30);
        HashMap<String, Integer> doubleFids = (HashMap<String, Integer>) csvUtils.findAllDoubleFields(startingDataContainer.getData());
        System.out.println(doubleFids);
        HashMap<String, Double> avgs = (HashMap<String, Double>) csvUtils.calculateAvgValues(startingDataContainer.getData(), doubleFids);
        System.out.println(avgs);
        csvUtils.saveDataToFile(startingDataContainer.getData(), "DATA/csvData2.csv");
        String pathToFile2 = "DATA/jsonData.json";
        JSONUtilsAdapter<JSONRecords> jsonUtils = new JSONUtilsAdapter<>();
        StartingDataContainer<JSONRecords> startingDataContainer2 = jsonUtils.readFromFile(pathToFile2, false, JSONRecords.class);
        jsonUtils.listAllRecords(startingDataContainer2.getData(), startingDataContainer2.getHeaders());
        jsonUtils.listParticularRecord(startingDataContainer2.getData(), 30);
        HashMap<String, Integer> doubleFids2 = (HashMap<String, Integer>) jsonUtils.findAllDoubleFields(startingDataContainer2.getData());
        System.out.println(doubleFids2);
        HashMap<String, Double> avgs2 = (HashMap<String, Double>) jsonUtils.calculateAvgValues(startingDataContainer2.getData(), doubleFids2);
        System.out.println(avgs2);
        jsonUtils.saveDataToFile(startingDataContainer2.getData(), "DATA/jsonData2.json");
    }
}