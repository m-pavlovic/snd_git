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
    }
}