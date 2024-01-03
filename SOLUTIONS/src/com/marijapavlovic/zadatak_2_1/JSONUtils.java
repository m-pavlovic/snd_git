package com.marijapavlovic.zadatak_2_1;

import java.util.List;
import java.util.Map;

public class JSONUtils implements WebDataProcessor {
    @Override
    public List readDataFromFile(String pathToFile, Class type) {
        return null;
    }

    @Override
    public void saveDataToFile(List data, String pathToFile) {

    }

    @Override
    public void listAllFetchRecords(List data) {

    }

    @Override
    public void listRecordInPosition(List data, int position) {

    }

    @Override
    public Map<String, Integer> findDoubleFields(List data) {
        return null;
    }

    @Override
    public Map<String, Double> calculateAvgValues(List data, Map doubleFields) {
        return null;
    }
}
