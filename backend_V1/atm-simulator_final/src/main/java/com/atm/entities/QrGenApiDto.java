package com.atm.entities;


public class QrGenApiDto {
    private String tranId;
    private int atmId;
    private double amount;

    public QrGenApiDto(String tranId, int atmId, double amount) {
        this.tranId = tranId;
        this.atmId = atmId;
        this.amount = amount;
    }

    // Getters and setters

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

