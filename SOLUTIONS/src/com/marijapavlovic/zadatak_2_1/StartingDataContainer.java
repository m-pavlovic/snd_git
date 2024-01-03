package com.marijapavlovic.zadatak_2_1;

import java.util.List;

public class StartingDataContainer<E> {
    private List<E> data;
    private String[] headers;

    public StartingDataContainer(String[] headers, List<E> data) {
        this.data = data;
        this.headers = headers;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }
}