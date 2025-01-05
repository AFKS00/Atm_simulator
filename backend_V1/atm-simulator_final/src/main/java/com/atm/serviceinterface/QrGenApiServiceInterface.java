package com.atm.serviceinterface;

import com.atm.entities.QrGenApi;

public interface QrGenApiServiceInterface {
	 public void saveTransaction(String tranId, int atmId, double amount,
             String qrGenerationStatus);
	 public QrGenApi getLastTransaction();
}
