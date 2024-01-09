package com.marijapavlovic.zadatak_2_1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JSONUtilsAdapter<E> implements DataProcessor<E> {
    private Gson gson;
    private JSONUtils<E> jsonUtils;

    public JSONUtilsAdapter() {
        this.gson = new Gson();
        this.jsonUtils = new JSONUtils<>();
    }

    @Override
    public StartingDataContainer<E> readFromFile(String pathToFile, boolean hasHeader, Class<E> type) {
        try (Reader reader = new FileReader(pathToFile)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            JsonArray jsonArray = jsonObject.getAsJsonArray("DBRecords");

            Type listType = TypeToken.getParameterized(List.class, type).getType();
            List<E> data = gson.fromJson(jsonArray, listType);

            String[] headers = null;
            if (hasHeader) {
                headers = jsonArray.get(0).getAsJsonObject().keySet().toArray(new String[0]);
            }
            return new StartingDataContainer<>(headers, data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveDataToFile(List<E> data, String pathToFile) {
        jsonUtils.saveDataToFile(data, pathToFile);
    }

    @Override
    public void listAllRecords(List<E> dataRec, String[] headers) {
        jsonUtils.listAllFetchRecords(dataRec);
    }

    @Override
    public void listParticularRecord(List<E> dataRec, int index) {
        jsonUtils.listRecordInPosition(dataRec, index);
    }

    @Override
    public Map<String, Integer> findAllDoubleFields(List<E> data) {
        return jsonUtils.findDoubleFields(data);
    }

    @Override
    public Map<String, Double> calculateAvgValues(List<E> data, Map<String, Integer> doubleFields) {
        return jsonUtils.calculateAvgValues(data, doubleFields);
    }
}