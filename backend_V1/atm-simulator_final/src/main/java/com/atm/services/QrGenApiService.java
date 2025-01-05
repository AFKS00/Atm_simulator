package com.atm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atm.entities.QrGenApi;
import com.atm.entities.QrGenApiDto;
import com.atm.repositorie.QrGenRepository;

@Service
public class QrGenApiService {

	@Autowired
    private QrGenRepository qrGenRepository;
	//String tranId = UUID.randomUUID().toString().substring(0, 8);
    public void saveTransaction(String tranId, int atmId, double amount) {
        QrGenApi qrGenApi = new QrGenApi();
        qrGenApi.setTranId(tranId);
        qrGenApi.setAtmId(atmId);
        qrGenApi.setAmount(amount);
        qrGenApi.setQrGenerationStatus("QR generated successfully");
        qrGenRepository.save(qrGenApi);
    }
	
    public QrGenApiDto getLatestTransaction() {
        QrGenApi latestTransaction = qrGenRepository.findTopByOrderByIdDesc();
        if (latestTransaction != null) {
            return new QrGenApiDto(latestTransaction.getTranId(), latestTransaction.getAtmId(), latestTransaction.getAmount());
        }
        return null;
    }
	public QrGenApiService() {
		// TODO Auto-generated constructor stub
	}

}
