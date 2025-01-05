    package com.atm.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(nullable = false)
    private String tranId;

    @Column(nullable = false)
    private int atmId;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String tranType;

    @Column(nullable = false)
    private String tranStatus;

    @Column(nullable = false)
    private String pspStatus;

    @Column(nullable = true)
    private String bankName;
    
    @Column(nullable = false)
    private String ifscCode;
    
    @Column(nullable = false)
    private String custName;
    
    @Column(nullable = false)
    private LocalDateTime insertedOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

	public Transaction(int id, String tranId, int atmId, int customerId, double amount, String tranType,
			String tranStatus, String pspStatus, String bankName, String ifscCode, String custName,
			LocalDateTime insertedOn, LocalDateTime updatedOn) {
		super();
		this.id = id;
		this.tranId = tranId;
		this.atmId = atmId;
		this.customerId = customerId;
		this.amount = amount;
		this.tranType = tranType;
		this.tranStatus = tranStatus;
		this.pspStatus = pspStatus;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.custName = custName;
		this.insertedOn = insertedOn;
		this.updatedOn = updatedOn;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	public String getPspStatus() {
		return pspStatus;
	}

	public void setPspStatus(String pspStatus) {
		this.pspStatus = pspStatus;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public LocalDateTime getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(LocalDateTime insertedOn) {
		this.insertedOn = insertedOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, atmId, bankName, custName, customerId, id, ifscCode, insertedOn, pspStatus, tranId,
				tranStatus, tranType, updatedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && atmId == other.atmId
				&& Objects.equals(bankName, other.bankName) && Objects.equals(custName, other.custName)
				&& customerId == other.customerId && id == other.id && Objects.equals(ifscCode, other.ifscCode)
				&& Objects.equals(insertedOn, other.insertedOn) && Objects.equals(pspStatus, other.pspStatus)
				&& Objects.equals(tranId, other.tranId) && Objects.equals(tranStatus, other.tranStatus)
				&& Objects.equals(tranType, other.tranType) && Objects.equals(updatedOn, other.updatedOn);
	}
    
    
}


    
