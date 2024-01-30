package com.marijapavlovic.zadatak_2_1;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CSVUtils<E> implements DataProcessor<E> {


    @Override
    public StartingDataContainer<E> readFromFile(String pathToFile, boolean hasHeader, Class<E> type) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(pathToFile));
            CsvToBean<E> csvToBean = new CsvToBeanBuilder(reader).withType(type).withIgnoreLeadingWhiteSpace(true).build();
            List<E> data = csvToBean.parse();
            String[] headers = null;
            if (hasHeader) {
                BufferedReader br = new BufferedReader(new FileReader(pathToFile));
                String headerLine = br.readLine();
                headers = headerLine.split(",");
            }
            return new StartingDataContainer<>(headers, data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveDataToFile(List<E> data, String pathToFile) {
        if (data.isEmpty()) {
            System.out.println("No data to save.");
            return;
        }
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(pathToFile));
            CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
    
            Class<?> clazz = data.get(0).getClass();
            
            Field[] fields = clazz.getDeclaredFields();
            String[] headers = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                headers[i] = fields[i].getName();
            }
            csvWriter.writeNext(headers);

            for (E record : data) {
                String[] fieldsData = record.toString().split("\\s*\\|\\s*");
                csvWriter.writeNext(fieldsData);
            }
            System.out.println("Data saved to file: " + pathToFile);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void listAllRecords(List<E> dataRec, String[] headers) {
    System.out.println("========================================= ALL RECORDS ============================================");
    if (headers != null) {
        for (String header : headers) {
            System.out.print(header + " | ");
        }
        System.out.println();
    }
    for (E record : dataRec) {
        System.out.println(record);
    }
}

    @Override
    public void listParticularRecord(List<E> data, int index) {
    if (index >= 0 && index < data.size()) {
        System.out.println(data.get(index));
    } else {
        System.out.println("Index out of bounds -> max index: " + (data.size() - 1) + " and you tried to access index: " + index + "!");
    }
}
    @Override
    public Map<String, Integer> findAllDoubleFields(List<E> data) {
        Map<String, Integer> doubleFields = new HashMap<>();
        if (data.isEmpty()) {
            return doubleFields;
        }
        Field[] fields = data.get(0).getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getType().equals(double.class)) {
                doubleFields.put(fields[i].getName(), i);
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
                try {
                    Field field = record.getClass().getDeclaredFields()[value];
                    field.setAccessible(true);
                    sum += field.getDouble(record);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            avgValues.put(key, sum / data.size());
        }
        return avgValues;
    }
}