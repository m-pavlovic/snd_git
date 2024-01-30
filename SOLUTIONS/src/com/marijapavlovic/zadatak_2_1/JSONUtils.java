package com.marijapavlovic.zadatak_2_1;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONUtils<E> implements WebDataProcessor<E> {
    private Gson gson = new Gson();

    @Override
    public List<E> readDataFromFile(String pathToFile, Class<E> type) {
        try (FileReader reader = new FileReader(pathToFile)) {
            Type listType = TypeToken.getParameterized(List.class, type).getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveDataToFile(List<E> data, String pathToFile) {
        try (FileWriter writer = new FileWriter(pathToFile)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listAllFetchRecords(List<E> data) {
        System.out.println("========================================= ALL RECORDS ============================================");
        String headers = "";
        JsonObject jsonObject = gson.toJsonTree(data.get(0)).getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            headers += key + " | ";
        }
        System.out.println(headers);
        for (E record : data) {
            System.out.println(record);
        }
    }

    @Override
    public void listRecordInPosition(List<E> data, int position) {
        if (position >= 0 && position < data.size()) {
            System.out.println(data.get(position));
        } else {
            System.out.println("Index out of bounds -> max index: " + (data.size() - 1) + " and you tried to access index: " + position + "!");
        }
    }

    @Override
    public Map<String, Integer> findDoubleFields(List<E> data) {
        Map<String, Integer> doubleFields = new HashMap<>();
        if (data.isEmpty()) {
            return doubleFields;
        }
        JsonObject jsonObject = gson.toJsonTree(data.get(0)).getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            if (value.isJsonPrimitive() && value.getAsJsonPrimitive().isNumber()) {
                doubleFields.put(key, 0);
            }
        }
        return doubleFields;
    }

    @Override
    public Map<String, Double> calculateAvgValues(List<E> data, Map<String, Integer> doubleFields) {
        Map<String, Double> avgValues = new HashMap<>();
        if (data.isEmpty()) {
            return avgValues;
        }
        for (Map.Entry<String, Integer> entry : doubleFields.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            double sum = 0;
            for (E record : data) {
                JsonObject jsonObject = gson.toJsonTree(record).getAsJsonObject();
                sum += jsonObject.get(key).getAsDouble();
            }
            avgValues.put(key, sum / data.size());
        }
        return avgValues;
    }

}