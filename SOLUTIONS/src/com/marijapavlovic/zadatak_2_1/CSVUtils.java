package com.marijapavlovic.zadatak_2_1;

import java.util.List;
import java.util.Map;

public class CSVUtils implements DataProcessor {
    @Override
    public StartingDataContainer readFromFile(String pathToFile, boolean hasHeader, Class type) {
        return null;
    }

    @Override
    public void saveDataToFile(List data, String pathToFile) {

    }

    @Override
    public void listAllRecords(List dataRec, String[] headers) {

    }

    @Override
    public void listParticularRecord(List dataRec, int index) {

    }

    @Override
    public Map<String, Integer> findAllDoubleFields(List data) {
        return null;
    }

    @Override
    public Map<String, Double> calculateAvgValues(List data, Map doubleFields) {
        return null;
    }
}
