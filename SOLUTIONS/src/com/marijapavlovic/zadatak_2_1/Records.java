package com.marijapavlovic.zadatak_2_1;

import com.opencsv.bean.CsvBindByName;

public class Records {

    
    @CsvBindByName
    private String userName;
    @CsvBindByName
    private int yearsActive;
    @CsvBindByName
    private int numberOfTotalPurchases;
    @CsvBindByName
    private double totalSpendEUR;
    @CsvBindByName
    private String regionEU;
    @CsvBindByName
    private String preferredPaymentMethod;

    

    public String getUserName() {
        return userName;
    }

    public int getYearsActive() {
        return yearsActive;
    }

    public int getNumberOfTotalPurchases() {
        return numberOfTotalPurchases;
    }

    public double getTotalSpendEUR() {
        return totalSpendEUR;
    }

    public String getRegionEU() {
        return regionEU;
    }

    public void setRegionEU(String regionEU) {
        this.regionEU = regionEU;
    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setYearsActive(int yearsActive) {
        this.yearsActive = yearsActive;
    }

    public void setNumberOfTotalPurchases(int numberOfTotalPurchases) {
        this.numberOfTotalPurchases = numberOfTotalPurchases;
    }

    public void setTotalSpendEUR(double totalSpendEUR) {
        this.totalSpendEUR = totalSpendEUR;
    }

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }


    @Override
    public String toString() {
        return userName + " | " + yearsActive + " | " + numberOfTotalPurchases + " | " + totalSpendEUR + " | " + regionEU + " | " + preferredPaymentMethod;
    }

}
