package com.atm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class QrGenApi {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
        @Column
	    private int atmId;
        @Column
        private double amount;
        @Column
        private String tranId;
        @Column
        private String qrGenerationStatus;

	    public QrGenApi() {
	       
	    }

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
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

	    public String getTranId() {
	        return tranId;
	    }

	    public void setTranId(String tranId) {
	        this.tranId = tranId;
	    }

	    public String getQrGenerationStatus() {
	        return qrGenerationStatus;
	    }

	    public void setQrGenerationStatus(String qrGenerationStatus) {
	        this.qrGenerationStatus = qrGenerationStatus;
	    }

	    @Override
	    public String toString() {
	        return "Transaction1{" +
	                "id=" + id +
	                ", atmId=" + atmId +
	                ", amount=" + amount +
	                ", tranId='" + tranId + '\'' +
	                ", qrGenerationStatus='" + qrGenerationStatus + '\'' +
	                '}';
	    }

	

}
