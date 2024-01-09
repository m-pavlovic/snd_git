package com.marijapavlovic.zadatak_2_1;

public class JSONRecords {
    

    /*
     * userName": "Henry",
      "isInEU": "No",
      "activeTotal": 4,
      "totalPurchases": 95,
      "totalSpendEUR": 1100.40,
      "payment": "Stripe",
      "usedWebBrowser": "Brave"
     */

    private String userName;
    private String isInEU;
    private int activeTotal;
    private int totalPurchases;
    private double totalSpendEUR;
    private String payment;
    private String usedWebBrowser;


    public String getUserName() {
        return userName;
    }

    public String getIsInEU() {
        return isInEU;
    }

    public int getActiveTotal() {
        return activeTotal;
    }

    public int getTotalPurchases() {
        return totalPurchases;
    }

    public double getTotalSpendEUR() {
        return totalSpendEUR;
    }

    public String getPayment() {
        return payment;
    }

    public String getUsedWebBrowser() {
        return usedWebBrowser;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIsInEU(String isInEU) {
        this.isInEU = isInEU;
    }

    public void setActiveTotal(int activeTotal) {
        this.activeTotal = activeTotal;
    }

    public void setTotalPurchases(int totalPurchases) {
        this.totalPurchases = totalPurchases;
    }

    public void setTotalSpendEUR(double totalSpendEUR) {
        this.totalSpendEUR = totalSpendEUR;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setUsedWebBrowser(String usedWebBrowser) {
        this.usedWebBrowser = usedWebBrowser;
    }


    @Override
    public String toString() {
        return userName + " | " + isInEU + " | " + activeTotal + " | " + totalPurchases + " | " + totalSpendEUR + " | " + payment + " | " + usedWebBrowser;
    }

}
