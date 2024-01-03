package com.marijapavlovic.zadatak_2_1;

import java.util.List;
import java.util.Map;

public interface WebDataProcessor <E> {

    List<E> readDataFromFile(String pathToFile, Class<E> type);

    void saveDataToFile(List<E> data, String pathToFile);

    void listAllFetchRecords(List<E> data);

    void listRecordInPosition(List<E> data, int position);

    Map<String, Integer> findDoubleFields(List<E> data);

    Map<String, Double> calculateAvgValues(List<E> data, Map<String, Integer> doubleFields);
}
