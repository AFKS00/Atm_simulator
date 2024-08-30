package com.atm.entities;



public class QrGenApiRequest {
    private int atmId;
    private double amount;

    // Getters and setters

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
