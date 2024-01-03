package com.marijapavlovic.zadatak_2_1;

import com.opencsv.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
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
        if (data.size() > 0) {
            Map<String, Integer> doubleFields = new HashMap<>();
            E firstRecord = data.get(0);
            int i = 0;
            for (String field : firstRecord.toString().split("\\s*\\|\\s*")) {
                try {
                    Double.parseDouble(field);
                    doubleFields.put(field, i);
                } catch (NumberFormatException e) {
                    // Ignore
                }
                i++;
            }
            return doubleFields;
        } else {
            return null;
            
        }
    }

    @Override
    public Map<String, Double> calculateAvgValues(List<E> data, Map<String, Integer> doubleFields) {
        if (data.size() > 0) {
            Map<String, Double> avgValues = new HashMap<>();
            for (Map.Entry<String, Integer> entry : doubleFields.entrySet()) {
                String fieldName = entry.getKey();
                int fieldIndex = entry.getValue();
                double sum = 0;
                for (E record : data) {
                    String[] fields = record.toString().split("\\s*\\|\\s*");
                    sum += Double.parseDouble(fields[fieldIndex]);
                }
                avgValues.put(fieldName, sum / data.size());
            }
            return avgValues;
        } else {
            return null;
        }
    }
}