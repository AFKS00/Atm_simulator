package com.atm.entities;

import java.sql.Date;
import java.util.Objects;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	@Column
	private int bankId;
	@Column
	private double currBalance;
	@Column
	private int pin;
	@Column
	private Date insertedOn;
	@Column
	private Date updatedOn;
	@Column
	private int mobileNo;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public double getCurrBalance() {
		return currBalance;
	}
	public void setCurrBalance(double currBalance) {
		this.currBalance = currBalance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Date getInsertedOn() {
		return insertedOn;
	}
	public void setInsertedOn(Date insertedOn) {
		this.insertedOn = insertedOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bankId, currBalance, custId, insertedOn, mobileNo, pin, updatedOn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return bankId == other.bankId
				&& Double.doubleToLongBits(currBalance) == Double.doubleToLongBits(other.currBalance)
				&& custId == other.custId && Objects.equals(insertedOn, other.insertedOn) && mobileNo == other.mobileNo
				&& pin == other.pin && Objects.equals(updatedOn, other.updatedOn);
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", bankId=" + bankId + ", currBalance=" + currBalance + ", pin=" + pin
				+ ", insertedOn=" + insertedOn + ", updatedOn=" + updatedOn + ", mobileNo=" + mobileNo + "]";
	}
	public Customer(int custId, int bankId, double currBalance, int pin, Date insertedOn, Date updatedOn,
			int mobileNo) {
		super();
		this.custId = custId;
		this.bankId = bankId;
		this.currBalance = currBalance;
		this.pin = pin;
		this.insertedOn = insertedOn;
		this.updatedOn = updatedOn;
		this.mobileNo = mobileNo;
	}
}
