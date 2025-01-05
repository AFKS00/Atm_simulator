package com.atm.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atm.entities.Atm;
import com.atm.entities.Check;
import com.atm.entities.QRRequest;
import com.atm.entities.Transaction;
import com.atm.services.TransactionService;

@RestController
@CrossOrigin(origins={"*","https://localhost:3001"})
public class TransactionController {
	@Autowired
	private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
	

    
	public void insertTransactionDetails(@RequestBody Transaction details)
	{
		transactionService.saveTransaction(details);
		System.out.println("Inserted Successful" + details);
	}
    
    @GetMapping("/api/Getalltranc")
	public List<Transaction> getAlltranc()
	{
		return transactionService.FindAlltranc();
	}
    
    @PostMapping("/api/checkstatus")
    public String checkStatus(@RequestBody Check transactionId)
    {
    	System.out.println(transactionId);
    	return transactionService.checkStatus(transactionId);
    }
	
    
    
    @PostMapping("/api/submit-transaction-cardless")
    public ResponseEntity<String> submitTransaction(@RequestBody QRRequest qrRequest) {
        System.out.println("Received data: " + qrRequest);
       

       //Check if values are non-zero before saving
        if (qrRequest.getAmount() <= 0 || qrRequest.getAtmId() <= 0 || qrRequest.getCustomerId() <= 0 ) {
            System.out.println("Invalid values - Amount: " + qrRequest.getAmount() + ", ATM ID: " + qrRequest.getAtmId() + ", Customer ID: " + qrRequest.getCustomerId());
            return new ResponseEntity<>("Invalid data received", HttpStatus.BAD_REQUEST);
        }
        
        try {
           //  Autogenerate transaction ID if not already set
            if (qrRequest.getTranId() == null || qrRequest.getTranId().isEmpty()) {
                qrRequest.setTranId(UUID.randomUUID().toString().substring(0, 8));
            }

            transactionService.saveCardlessTransaction(
                qrRequest.getTranId(),		
                qrRequest.getAmount(),
                qrRequest.getCustomerId(),
                qrRequest.getAtmId(),
                "DEBIT", // Transaction type
                "Completed", // Transaction status
                "Success" // PSP status
            );
            
            transactionService.updatecardlesscustomerbankbalance(qrRequest.getTranId(), qrRequest.getAmount());
            
            String responseMessage = String.format(
                "Transaction saved successfully. Amount: %.2f, CustomerId: %d, AtmId: %d",
                qrRequest.getAmount(),
                qrRequest.getCustomerId(),
                qrRequest.getAtmId()  
            );

            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
//    @PostMapping("/api/submit-transaction-updateamount")
//    public void updateAmount(String transid ,double amount) {
//    	transactionService.updatecardlesscustomerbankbalance(transid , amount);
//    }

}
